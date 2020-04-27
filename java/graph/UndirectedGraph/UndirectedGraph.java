package UndirectedGraph;

import Base.Graph;
import Base.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UndirectedGraph<T> implements Graph<T> {

    public HashMap<T, UndirectedNode<T>> map;

    public UndirectedGraph() {
        this.map = new HashMap<>();
    }

    public Set<T> keys() {
        return map.keySet();
    }

    // 无向图 两遍都要加
    public void addEdge(T from, T to) {
        if (!map.containsKey(from)) {
            map.put(from, new UndirectedNode<>(to));
        }
        UndirectedNode<T> temp = map.get(from);
        // 说明加入了重复边
        if (!temp.addNode(to)) return;

        if (!map.containsKey(to)) {
            map.put(to, new UndirectedNode<>(from));
        }
        UndirectedNode<T> tempTo = map.get(to);
        tempTo.addNode(from);
    }

    public Node<T> adjacent(T from) {
        return this.map.getOrDefault(from, null);
    }


    @Override
    public String toString() {
        return "UndirectedGraph{" +
                "map=" + map +
                '}';
    }

    public static void main(String[] args) {
        UndirectedGraph<Integer> test = new UndirectedGraph<Integer>();
        test.addEdge(1,2);
        test.addEdge(1,3);
        test.addEdge(4,5);
//        test.addEdge(2,3);

        System.out.println(test);
//
//        System.out.println(test.adjacent(1));
//
//        DFS.DFSWithRecursion(test);
//        DFS.DFSWithoutRecursion(test);
//        BFS.BFS(test);

        Connected<Integer> connected = new Connected<Integer>(test);

        System.out.println(connected.ids);
        System.out.println(connected.connected(1,4));

        CheckCycle<Integer> cycle = new CheckCycle<Integer>(test);

        System.out.println(cycle.hasCycle);
    }
}

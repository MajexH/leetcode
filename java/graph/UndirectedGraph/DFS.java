package UndirectedGraph;

import Base.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DFS {

    public static <T> void DFSWithRecursion(Graph<T> graph) {
        Set<T> memo = new HashSet<>();
        for (T start : graph.keys()) {
            if (!memo.contains(start))
                DFSWithRecursion(graph, start, memo);
        }
    }

    public static <T> void DFSWithoutRecursion(Graph<T> graph) {
        Set<T> memo = new HashSet<>();
        for (T start : graph.keys()) {
            if (!memo.contains(start))
                DFSWithOutRecursion(graph, start, memo);
        }
    }

    public static <T> void DFSWithRecursion(Graph<T> graph, T start, Set<T> memo) {
        System.out.println(start);
        UndirectedNode<T> node = (UndirectedNode<T>) graph.adjacent(start);
        memo.add(start);
        while (node != null) {
            if (!memo.contains(node.to)) DFS.DFSWithRecursion(graph, node.to, memo);
            node = node.next;
        }
    }

    public static <T> void DFSWithOutRecursion(Graph<T> graph, T start, Set<T> memo) {
        LinkedList<T> stack = new LinkedList<>();
        stack.add(start);
        memo.add(start);
        while (stack.size() != 0) {
            T top = stack.removeLast();
            System.out.println(top);

            UndirectedNode<T> temp = (UndirectedNode<T>) graph.adjacent(top);
            while (temp != null) {
                if (!memo.contains(temp.to)) {
                    stack.add(temp.to);
                    memo.add(temp.to);
                }
                temp = temp.next;
            }
        }
    }

}

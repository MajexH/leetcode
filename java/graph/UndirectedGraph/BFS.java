package UndirectedGraph;

import Base.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BFS {

    public static <T> void BFS(Graph<T> graph) {
        Set<T> memo = new HashSet<>();
        for (T start : graph.keys()) {
            if (!memo.contains(start))
                BFS(graph, start, memo);
        }
    }

    public static <T> void BFS(Graph<T> graph, T start, Set<T> memo) {
        LinkedList<T> queue = new LinkedList<>();
        queue.add(start);
        memo.add(start);
        while (!queue.isEmpty()) {
            T first = queue.removeFirst();
            System.out.println(first);
            UndirectedNode<T> temp = (UndirectedNode<T>) graph.adjacent(first);
            while (temp != null) {
                if (!memo.contains(temp.to)) {
                    queue.add(temp.to);
                    memo.add(temp.to);
                }
                temp = temp.next;
            }
        }
    }
}

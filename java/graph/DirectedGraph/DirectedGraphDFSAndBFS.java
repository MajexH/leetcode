package DirectedGraph;

import java.util.Deque;
import java.util.LinkedList;

public class DirectedGraphDFSAndBFS {

    public void DFS(DirectedGraph g) {
        boolean[] memo = new boolean[g.getCapacity()];
        for (int i = 0; i < g.getCapacity(); i++) {
            if (!memo[i]) {
                DFSRecursion(g, i, memo, new boolean[g.getCapacity()]);
            }
        }
    }

    private void DFSRecursion(DirectedGraph g, int start, boolean[] memo, boolean[] marked) {
        memo[start] = true;
        System.out.printf("%s ", start);
        marked[start] = true;
        for (int i : g.adj(start)) {
            if (!marked[i]) {
                DFSRecursion(g, i, memo, marked);
            }
        }
        marked[start] = false;
    }

    public void BFS(DirectedGraph g) {
        for (int i = 0; i < g.getCapacity(); i++) {
            BFSWithStart(g, i);
        }
    }

    public void BFSWithStart(DirectedGraph g, int start) {
        boolean[] memo = new boolean[g.getCapacity()];
        Deque<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            memo[node] = true;
            System.out.printf("%d ", node);
            for (int adj : g.adj(node)) {
                if (!memo[adj]) {
                    queue.push(adj);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(13);
        g.addEdge(1, 0);
        g.addEdge(0, 1);
        g.addEdge(3, 4);
        g.addEdge(2, 6);
        g.addEdge(8, 3);
        g.addEdge(5, 1);
        g.addEdge(1, 7);

        new DirectedGraphDFSAndBFS().DFS(g);
        System.out.println();
        new DirectedGraphDFSAndBFS().BFS(g);
    }
}

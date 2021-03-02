package DirectedWeightGraph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class TopologySort {

    // 采用 dfs 做的 topologySort
    // 保证无环
    public static int[] topologySort(DirectedWeightGraph g) {
        boolean[] marked = new boolean[g.getCapacity()];

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < g.getCapacity(); i++) {
            // marked 标识标记过的点
            if (!marked[i]) {
                dfs(g, marked, i, stack);
            }
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.removeLast();
        }
        return res;
    }

    public static void dfs(DirectedWeightGraph g, boolean[] marked, int start, Deque<Integer> stack) {
        marked[start] = true;

        for (Edge adj : g.adj(start)) {
            if (!marked[adj.to]) {
                dfs(g, marked, adj.to, stack);
            }
        }
        stack.addLast(start);
    }

    public static void main(String[] args) {
        DirectedWeightGraph g = new DirectedWeightGraph(8);
        g.addEdge(5, 4, 35);
        g.addEdge(4, 7, 37);
        g.addEdge(5, 7, 28);
        g.addEdge(5, 1, 32);
        g.addEdge(4, 0, 38);
        g.addEdge(0, 2, 26);
        g.addEdge(3, 7, 39);
        g.addEdge(1, 3, 29);
        g.addEdge(7, 2, 34);
        g.addEdge(6, 2, 40);
        g.addEdge(3, 6, 52);
        g.addEdge(6, 0, 58);
        g.addEdge(6, 4, 93);

        System.out.println(Arrays.toString(topologySort(g)));
    }
}

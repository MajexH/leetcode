package DirectedWeightGraph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class TopologyMinPathReview {
    // 使用拓扑排序，所以要求是无环图
    // 其原理在于 根据拓扑排序取访问 因为是从无入度的点开始
    // 所以一旦遍历完了这个点 就不会再有 relax 的操作 针对这个点

    public static int[] topologySort(DirectedWeightGraph g) {
        Deque<Integer> paths = new LinkedList<>();
        boolean[] marked = new boolean[g.getCapacity()];
        for (int i = 0; i < g.getCapacity(); i++) {
            if (!marked[i]) dfs(paths, g, i, marked);
        }
        int[] res = new int[paths.size()];
        int index = 0;
        while (paths.size() > 0) {
            res[index++] = paths.removeLast();
        }
        return res;
    }

    private static void dfs(Deque<Integer> paths, DirectedWeightGraph g, int start, boolean[] marked) {
        marked[start] = true;
        for (Edge adj : g.adj(start)) {
            if (!marked[adj.to]) {
                dfs(paths, g, adj.to, marked);
            }
        }
        paths.addLast(start);
    }

    public static Edge[] topologyMinPath(DirectedWeightGraph g, int start) {
        int[] topologySort = topologySort(g);

        Edge[] edgeTo = new Edge[g.getCapacity()];
        int[] dstTo = new int[g.getCapacity()];
        Arrays.fill(dstTo, Integer.MAX_VALUE);
        dstTo[start] = 0;

        for (int node : topologySort) {
            relax(g, node, edgeTo, dstTo);
        }
        return edgeTo;
    }

    private static void relax(DirectedWeightGraph g, int node, Edge[] edgeTo, int[] dstTo) {
        for (Edge adj : g.adj(node)) {
            int to = adj.to;
            if (dstTo[to] > dstTo[node] + adj.weight) {
                dstTo[to] = dstTo[node] + adj.weight;
                edgeTo[to] = adj;
            }
        }
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

        g = new DirectedWeightGraph(8);
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

        System.out.println(Arrays.toString(topologyMinPath(g, 5)));
    }
}

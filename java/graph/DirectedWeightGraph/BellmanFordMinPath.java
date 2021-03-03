package DirectedWeightGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BellmanFordMinPath {

    // 这个算法只能处理没有负权重环的有向图
    // 因为带有负权重环的图可以得到任意短的权重 是无效的
    public static Edge[] bellmanFordMinPath(DirectedWeightGraph g, int start) {
        // 所以 如果遍历所有的点 同时 relax 所有的 边 就可以得到一个结果
        // 其效率为 o(v + e)
        // 但是 可以考虑一个问题 就是只有在上轮循环中更新过的点 才有可能使 距离更短，所以 用一个 queue 来保存这样的点

        // 转上轮对 dst 数组有贡献的点
        Queue<Integer> queue = new LinkedList<>();
        // 结果
        Edge[] edgeTo = new Edge[g.getCapacity()];
        // 距离初始化
        int[] dst = new int[g.getCapacity()];
        Arrays.fill(dst, Integer.MAX_VALUE);
        dst[start] = 0;
        // 因为 queue 里面不能有重复节点 所以用这个来判断
        boolean[] inQueue = new boolean[g.getCapacity()];
        // 执行 relax 的次数
        int cost = 0;

        // 最开始的节点
        queue.add(start);
        // TODO 这个时候还要检查负权重环
        // 这个地方只需要检查是否是成环即可
        while (!queue.isEmpty()) {
            relax(g, queue.remove(), dst, edgeTo, queue, inQueue);
        }
        return edgeTo;
    }

    // 在放松的时候同时更新 queue
    private static void relax(DirectedWeightGraph g, int node, int[] dst, Edge[] edgeTo, Queue<Integer> queue, boolean[] inQueue) {
        for (Edge adj : g.adj(node)) {
            int to = adj.to;

            // 更新
            if (dst[to] > dst[node] + adj.weight) {
                edgeTo[to] = adj;
                dst[to] = dst[node] + adj.weight;
                if (!inQueue[node]) {
                    inQueue[node] = true;
                    // 这有这轮已经更新过的 到 to 的更短距离 其他才可能更短
                    queue.add(to);
                }
            }
            // TODO 检查负权重环
        }
    }

    private static List<Edge> findNegativeCycle(DirectedWeightGraph g, Edge[] edgeTo) {
        int V = edgeTo.length;
        DirectedWeightGraph spt;
        spt = new DirectedWeightGraph(V);
        for (int v = 0; v < V; v++) {
            if (edgeTo[v] != null) {
                spt.addEdge(edgeTo[v]);
            }
        }
        DirectedWeightGraphCycleFinder cf;
        cf = new DirectedWeightGraphCycleFinder(spt);
        return cf.getCycleStack();
    }

    public static void main(String[] args) {
        DirectedWeightGraph g = new DirectedWeightGraph(8);
        g.addEdge(4, 5, 35);
        g.addEdge(5, 4, 35);
        g.addEdge(4, 7, 37);
        g.addEdge(5, 7, 28);
        g.addEdge(7, 5, 28);
        g.addEdge(5, 1, 32);
        g.addEdge(0, 4, 38);
        g.addEdge(0, 2, 26);
        g.addEdge(7, 3, 39);
        g.addEdge(1, 3, 29);
        g.addEdge(2, 7, 34);
        g.addEdge(6, 2, 40);
        g.addEdge(3, 6, 52);
        g.addEdge(6, 0, 58);
        g.addEdge(6, 4, 93);

        System.out.println(Arrays.toString(bellmanFordMinPath(g, 1)));;
    }
}

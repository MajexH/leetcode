package DirectedWeightGraph;

import java.util.Arrays;

public class TopologyMinPath {

    // 使用拓扑排序的单源最短路经
    // 只能处理无环的情况
    // 拓扑排序只能针对无环图
    // 由于 拓扑排序是从 无入度的点开始
    // 如果找最短路径从这儿开始的话 这个点 一定不会再次被访问到 所以只放松一次
    // 同理 解决单点无环图的最长路径 可以把 weight 取负 再来最短路径即可
    public static Edge[] topologyMinPath(DirectedWeightGraph g, int start) {

        int[] topologyPath = TopologySort.topologySort(g);
        Edge[] res = new Edge[g.getCapacity()];
        // 初始化距离
        int[] dst = new int[g.getCapacity()];
        Arrays.fill(dst, Integer.MAX_VALUE);
        dst[start] = 0;

        for (int node : topologyPath) {
            relax(g, res, dst, node);
        }
        return res;
    }

    private static void relax(DirectedWeightGraph g, Edge[] res, int[] dst, int node) {

        for (Edge adj : g.adj(node)) {
            // 如果之前遍历的 到 adj.to 的距离 比从 node 经过 adj 到达 adj.to 的距离长 说明该更新了
            if (dst[adj.to] > dst[node] + adj.weight) {
                res[adj.to] = adj;
                dst[adj.to] = dst[node] + adj.weight;
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

        System.out.println(Arrays.toString(topologyMinPath(g, 5)));
    }
}

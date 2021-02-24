package DirectedGraph;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphStrongConnected {

    public static List<Integer> KosarajuConnected(DirectedGraph g) {

        // 保存的强连通分量的 id
        // ids[i] 表示 i 节点属于哪个 强连通分量 id
        List<Integer> ids = new ArrayList<>(g.getCapacity());
        for (int i = 0; i < g.getCapacity(); i++) {
            ids.add(-1);
        }
        // 遍历的时候的强连通分量 id
        int count = 0;
        // 先得到 反图 的拓扑排序
        List<Integer> order = TopologySort.topologySortWithRecursion(g.reverse());
        boolean[] memo = new boolean[g.getCapacity()];
        for (int node : order) {
            if (!memo[node]) {
                recursionDFS(g, node, count, memo, ids);
                count++;
            }
        }
        // 根据拓扑排序 DFS
        return ids;
    }

    private static void recursionDFS(DirectedGraph g, int start, int count, boolean[] memo, List<Integer> ids) {
        memo[start] = true;
        ids.set(start, count);
        for (int adj : g.adj(start)) {
            if (!memo[adj]) {
                recursionDFS(g, adj, count, memo, ids);
            }
        }
    }

    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(13);
        g.addEdge(1, 2);
        g.addEdge(3, 1);
        g.addEdge(6, 3);
        g.addEdge(4, 7);
        g.addEdge(2, 0);
        g.addEdge(11, 8);
        g.addEdge(10, 1);
        g.addEdge(0, 7);
        g.addEdge(0, 6);


        System.out.println(KosarajuConnected(g));
    }
}

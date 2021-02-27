package UndirectedWeightGraph;

import java.util.*;

public class MinTreeKruskal {

    // 使用 并查集 来判断加入的边是否成环
    public static List<Edge> kruskalUseUnion(UndirectedWeightGraph g) {
        List<Edge> res = new ArrayList<>();
        Union uf = new Union(g.getCapacity());

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt((e) -> e.weight));
        pq.addAll(g.getEdges());

        // 最小生成树 只能有 V - 1 个 （V 为 node 数）
        while (!pq.isEmpty() && (res.size() < g.getCapacity() - 1)) {
            Edge e = pq.poll();
            assert e != null;
            int from = e.from, to = e.to;
            // 之前已经连接了最短的边 所以不用再连接了
            if (uf.connected(from, to)) continue;
            // 连接两条边
            uf.union(from, to);
            res.add(e);
        }
        return res;
    }

    public static void main(String[] args) {
        UndirectedWeightGraph g = new UndirectedWeightGraph(8);
        g.addEdge(4, 5, 35);
        g.addEdge(4, 7, 37);
        g.addEdge(5, 7, 28);
        g.addEdge(0, 7, 16);
        g.addEdge(1, 5, 32);
        g.addEdge(0, 4, 38);
        g.addEdge(2, 3, 17);
        g.addEdge(1, 7, 19);
        g.addEdge(0, 2, 26);
        g.addEdge(1, 2, 36);
        g.addEdge(1, 3, 29);
        g.addEdge(2, 7, 34);
        g.addEdge(6, 2, 40);
        g.addEdge(3, 6, 52);
        g.addEdge(6, 0, 58);
        g.addEdge(6, 4, 93);
        System.out.println(MinTree.lazyPrim(g));
        System.out.println(Arrays.toString(MinTree.prim(g)));

        System.out.println(kruskalUseUnion(g));
    }
}

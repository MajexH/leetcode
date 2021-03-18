package UndirectedWeightGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinTreeKruskalReview {

    private static class UnionFind {
        int[] parents;

        public UnionFind(int capacity) {
            this.parents = new int[capacity];
            Arrays.fill(parents, -1);
        }

        public void union(int n1, int n2) {
            int rootOfN1 = findRoot(n1);
            int rootOfN2 = findRoot(n2);

            // 已经关联上了
            if (rootOfN1 == rootOfN2) return;
            // 关联上
            this.parents[rootOfN2] = rootOfN1;
        }

        public int findRoot(int node) {
            if (this.parents[node] == -1) return node;
            return findRoot(this.parents[node]);
        }

        public boolean isConnected(int n1, int n2) {
            int rootOfN1 = findRoot(n1);
            int rootOfN2 = findRoot(n2);
            return rootOfN1 == rootOfN2;
        }
    }

    // 使用 并查集 来维护，使用的性质是树的边 只有 n - 1 条
    // 同时使用并查集来维护是否已经连接 （连接的话就意味着已经找到两个节点间的最短边）
    public static List<Edge> kruskalUseUnion(UndirectedWeightGraph g) {
        // 保存遍历的结果
        List<Edge> res = new ArrayList<>();

        UnionFind uf = new UnionFind(g.getCapacity());

        // 把所有的边直接加入进去
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.addAll(g.getEdges());

        while (!pq.isEmpty() && res.size() < g.getCapacity() - 1) {
            Edge e = pq.poll();
            assert e != null;
            // 已经找到了
            if (uf.isConnected(e.from, e.to)) continue;
            res.add(e);
            uf.union(e.from, e.to);
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
        System.out.println(MinTreeKruskal.kruskalUseUnion(g));
        System.out.println(kruskalUseUnion(g));
    }
}

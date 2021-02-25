package UndirectedWeightGraph;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MinTreeReview {

    // review lazy 的 prim 算法
    public static Deque<Edge> prim(UndirectedWeightGraph g) {
        boolean[] marked = new boolean[g.getCapacity()];
        // 保存 edge weight 最小的 小顶堆
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        // 返回的边
        Deque<Edge> res = new LinkedList<>();

        // 先加入一个边
        // 认定该图是连通的
        addEdgeToPQ(g, marked, 0, pq);

        while (!pq.isEmpty()) {
            Edge minEdge = pq.poll();
            // 已经找到了 from to 之间的最短距离 所以这是失效边
            if (marked[minEdge.from] && marked[minEdge.to]) continue;
            res.add(minEdge);
            if (!marked[minEdge.from]) addEdgeToPQ(g, marked, minEdge.from, pq);
            if (!marked[minEdge.to]) addEdgeToPQ(g, marked, minEdge.to, pq);
        }
        return res;
    }

    private static void addEdgeToPQ(UndirectedWeightGraph g, boolean[] marked, int node, PriorityQueue<Edge> pq) {
        marked[node] = true;
        for (Edge e : g.adj(node)) {
            if (!marked[e.other(node)]) {
                pq.add(e);
            }
        }
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
        System.out.println(prim(g));
    }
}

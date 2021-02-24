package UndirectedWeightGraph;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MinTree {

    // 最小生成树 指的是无向图中，能够生成的边的权重总和最小的树

    // prime 的最小生成树实际上是一个贪心算法
    // 通过 PriorityQueue 不停地生成权重最小的边
    public static Deque<Edge> prim(UndirectedWeightGraph g) {
        // 存储所有的边
        PriorityQueue<Edge> minQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        // 保存被访问过的节点
        boolean[] marked = new boolean[g.getCapacity()];
        // 保存返回的结果
        Deque<Edge> res = new LinkedList<>();

        // 保证 g 整体是连通的
        // 随意选取一个节点作为开始节点
        addEdgeToPQ(marked, minQueue, 0, g);

        while (!minQueue.isEmpty()) {
            // 抓到的一定是最短的路径
            Edge top = minQueue.poll();

            int from = top.from, to = top.to;

            // from to 两个断点都已经访问过 说明在两个端点之间已经找到最短的了
            if (marked[from] && marked[to]) continue;
            // 否则就找到最短的
            res.add(top);

            // 将两个端点的 edge 加入到 queue 中
            if (!marked[from]) addEdgeToPQ(marked, minQueue, from, g);
            if (!marked[to]) addEdgeToPQ(marked, minQueue, to, g);
        }
        return res;
    }

    public static void addEdgeToPQ(boolean[] marked, PriorityQueue<Edge> minQueue, int start, UndirectedWeightGraph g) {
        marked[start] = true;

        for (Edge e : g.adj(start)) {
            if (!marked[e.other(start)]) {
                // 另外一个断点没有访问过
                minQueue.add(e);
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

        System.out.println(prim(g));
    }
}

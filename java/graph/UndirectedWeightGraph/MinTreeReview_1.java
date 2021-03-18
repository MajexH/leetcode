package UndirectedWeightGraph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MinTreeReview_1 {

    // 最小生成树 实际上是针对 加权无向图来说
    // 每次选择最短的边来添加到树中 最后得到这个最小的生成树

    public static Deque<Edge> lazyPrim(UndirectedWeightGraph g) {
        // 标识是否已经访问了
        boolean[] marked = new boolean[g.getCapacity()];
        Deque<Edge> res = new LinkedList<Edge>();

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 先加入一个节点
        // 因为图是连通的 所以实际上随便加入一个点即可
        addEdgeToPQ(pq, g, marked, 0);

        while (!pq.isEmpty()) {
            Edge min = pq.poll();
            // 已经都找到了
            if (marked[min.from] && marked[min.to]) continue;
            // 加入结果 相当于这条边要么是 from 要么是 to 最短的
            res.add(min);
            // 把没有找到最短边的节点的所有边 加入 pq
            if (!marked[min.from]) addEdgeToPQ(pq, g, marked, min.from);
            if (!marked[min.to]) addEdgeToPQ(pq, g, marked, min.to);
        }
        return res;
    }


    private static void addEdgeToPQ(PriorityQueue<Edge> pq, UndirectedWeightGraph g, boolean[] marked, int start) {
        marked[start] = true;
        for (Edge adj : g.adj(start)) {
            if (!marked[adj.other(start)]) pq.add(adj);
        }
    }

    // 保存到这个边的最短距离
    private static class Pair implements Comparable<Pair> {
        int node, weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        // 实现小顶堆 通过小顶堆去遍历已经加入最小生成树 和 未加入最小生成树的点
        @Override
        public int compareTo(Pair o) {
            return weight - o.weight;
        }
    }

    // 即时版本的 prim 算法 其实质本质是分隔边的两个集合 然后不停的加入另外一个集合还未加入最小生成树的最短边
    private static Edge[] prim(UndirectedWeightGraph g) {
        // 保存到这个 i 这个点的最短边的引用
        Edge[] res = new Edge[g.getCapacity()];
        // 保存已经访问过的节点
        // 使用 mark 可以减少访问的次数
        boolean[] marked = new boolean[g.getCapacity()];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            addEdgeToPQ(g, pq.poll().node, pq, res, marked);
        }

        return res;
    }

    private static void addEdgeToPQ(UndirectedWeightGraph g, int node, PriorityQueue<Pair> pq, Edge[] res, boolean[] marked) {
        marked[node] = true;
        for (Edge adj : g.adj(node)) {
            int other = adj.other(node);
            // 已经找到到这个点的最短距离
            if (marked[other]) continue;
            // 说明要更新成到这个点更短的边
            if (res[other] == null || res[other].weight > adj.weight) {
                res[other] = adj;
                pq.removeIf(tmp -> tmp.node == other);
                pq.add(new Pair(other, adj.weight));
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
        System.out.println(lazyPrim(g));

        System.out.println(Arrays.toString(MinTree.prim(g)));
        System.out.println(Arrays.toString(prim(g)));
    }
}

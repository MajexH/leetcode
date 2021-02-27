package UndirectedWeightGraph;

import java.util.*;

public class MinTree {

    // 最小生成树 指的是无向图中，能够生成的边的权重总和最小的树

    // prime 的最小生成树实际上是一个贪心算法
    // 通过 PriorityQueue 不停地生成权重最小的边
    // lazyPrim 指的是在遍历的过程中 pq 中的边 是访问时才失效
    public static Deque<Edge> lazyPrim(UndirectedWeightGraph g) {
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

    private static class Pair {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return node == pair.node;
        }

        @Override
        public int hashCode() {
            return Objects.hash(node);
        }
    }

    // 实时的 prim 算法 与 lazy 不同的是
    // 在 v 这个节点 加入 pq 的时候 其余的非树阶段 应该只加入 到 树中最短的边
    // 相对来说 可以减少时间 因为 一个图的话 一般是 边比点多
    // 这个算法只用在 优先队列中保存点
    public static Edge[] prim(UndirectedWeightGraph g) {
        // 仍然使用一个 pq 保存最短的点 （到这个点的最短距离）
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        // edge[i] 保存 i 到 edge.to 的最短边长
        Edge[] edgeTo = new Edge[g.getCapacity()];
        boolean[] marked = new boolean[g.getCapacity()];

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            inTimeAddEdgeToPQ(g, top.node, marked, edgeTo, pq);
        }
        return edgeTo;
    }

    private static void inTimeAddEdgeToPQ(UndirectedWeightGraph g, int node, boolean[] marked, Edge[] edgeTo, PriorityQueue<Pair> pq) {
        marked[node] = true;

        for (Edge adj : g.adj(node)) {
            int otherNode = adj.other(node);
            // 已经找到了
            if (marked[otherNode]) continue;
            // 说明还没有找到到这个点的最短距离 或者
            // 现在的 edge 的 weight 更短 更新
            if (edgeTo[otherNode] == null || adj.weight < edgeTo[otherNode].weight) {
                edgeTo[otherNode] = adj;
                Pair p = new Pair(otherNode, adj.weight);
                for (Pair tmp : pq) {
                    // remove 掉已经失效的边
                    if (tmp.node == otherNode) {
                        pq.remove(tmp);
                    }
                    break;
                }
                pq.add(p);
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

        System.out.println(lazyPrim(g));
        System.out.println(Arrays.toString(prim(g)));
    }
}

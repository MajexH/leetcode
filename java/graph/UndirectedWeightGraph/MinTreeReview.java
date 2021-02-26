package UndirectedWeightGraph;

import java.util.*;

public class MinTreeReview {

    // review lazy 的 prim 算法
    public static Deque<Edge> lazyPrim(UndirectedWeightGraph g) {
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

    private static class Pair {
        int node;
        // 到这个点最小 weight
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // 及时的 prim 算法
    public static Edge[] prim(UndirectedWeightGraph g) {
        // lazy 的 prim 算法在判断边的时候 会把所有的边 加入 有对于稠密图来说  边的数量 >> 点的数量
        // 所以 及时的 prim 算法 会在加入边的时候判断

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        queue.add(new Pair(0, 0));
        // 标识是否访问
        boolean[] marked = new boolean[g.getCapacity()];
        // 保存结果 同时保存最短的 weight
        Edge[] edgeTo = new Edge[g.getCapacity()];
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            addPairToQueue(g, queue, edgeTo, p.node, marked);
        }
        return edgeTo;
    }

    /**
     *
     * @param g
     * @param queue 队列
     * @param edgeTo 结果数组
     * @param node 当前访问的 节点索引
     */
    public static void addPairToQueue(UndirectedWeightGraph g,  PriorityQueue<Pair> queue, Edge[] edgeTo, int node, boolean[] marked) {
        marked[node] = true;

        for (Edge adj : g.adj(node)) {
            // 因为是无向图 edge 两边都是一样的 所以该访问返回另一个点
            int other = adj.other(node);
            // 已经找到了最短边 因为 marked 访问了的话 一定是最短的
            if (marked[other]) continue;
            // 如果还没有边到这个点 或者 之前到这个点最短的边的权重比现在的打 就要更新
            if (edgeTo[other] == null || edgeTo[other].weight > adj.weight) {
                edgeTo[other] = adj;
                Pair p = new Pair(other, adj.weight);
                for (Pair tmp : queue) {
                    if (tmp.node == p.node) {
                        queue.remove(tmp);
                        break;
                    }
                }
                // 这个时候 之前保存的最短边 已经不是最短边 要更新
                queue.add(p);
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

package DirectedWeightGraph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraMinPath {

    public static class Pair {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // dijkstra 与 in time 的 prim 算法类似
    // 这些是找到单源最短路的
    public static Edge[] dijkstraMinPath(DirectedWeightGraph g, int start) {
        // 保存最短路径的边
        Edge[] edgeTo = new Edge[g.getCapacity()];
        // 保存最短路径的长度
        int[] distTo = new int[g.getCapacity()];
        for (int i = 0; i < g.getCapacity(); i++) {
            distTo[i] = Integer.MAX_VALUE;
        }
        distTo[start] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt((e) -> e.weight));

        pq.add(new Pair(start, 0));
        // 每次都找现在最短的路径 然后 relax 路径
        while (!pq.isEmpty()) {
            Pair min = pq.poll();
            relax(g, min.node, pq, edgeTo, distTo);
        }
        return edgeTo;
    }

    // relax 节点
    private static void relax(DirectedWeightGraph g, int node, PriorityQueue<Pair> pq, Edge[] edgeTo, int[] distTo) {
        for (Edge adj : g.adj(node)) {
            // 因为 edgeTo 保存的是之前遍历的最短的路径
            // 所以 如果通过现在这个点 + adj.weight 的距离 比 edgeTo 的短 就需要更新
            if (distTo[adj.to] > distTo[node] + adj.weight) {
                edgeTo[adj.to] = adj;
                distTo[adj.to] = distTo[node] + adj.weight;
                // 添加新的 或者 更新原来的节点的最小值
                Pair p = new Pair(adj.to, distTo[adj.to
                        ]);
                // 更新 pq
                for (Pair tmp : pq) {
                    if (tmp.node == adj.to) {
                        pq.remove(tmp);
                    }
                    break;
                }
                pq.add(p);
            }
        }
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

        System.out.println(Arrays.toString(dijkstraMinPath(g, 0)));
    }
}

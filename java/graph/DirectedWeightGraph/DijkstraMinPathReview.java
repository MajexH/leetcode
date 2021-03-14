package DirectedWeightGraph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraMinPathReview {

    private static class Pair implements Comparable<Pair> {
        // 连接到终点为 index 的地方
        int index;
        // 连接的距离
        int dst;

        // 小顶堆
        @Override
        public int compareTo(Pair o) {
            return dst - o.dst;
        }

        public Pair(int index, int dst) {
            this.index = index;
            this.dst = dst;
        }
    }

    // dijkstraMinPath
    public static Edge[] dijkstraMinPath(DirectedWeightGraph g, int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(start, 0));
        int[] dstTo = new int[g.getCapacity()];
        // 初始化
        Arrays.fill(dstTo, Integer.MAX_VALUE);
        dstTo[start] = 0;
        Edge[] edgeTo = new Edge[g.getCapacity()];

        while (!pq.isEmpty()) {
            relax(g, pq, pq.poll().index, dstTo, edgeTo);
        }
        return edgeTo;
    }

    private static void relax(DirectedWeightGraph g, PriorityQueue<Pair> pq, int node, int[] dst, Edge[] edgeTo) {
        for (Edge adj : g.adj(node)) {
            int to = adj.to;
            // 如果之前保存的 到 to 节点的 距离 大于通过 node 节点经过 adj 边到 to 的距离就要更新
            if (dst[to] > dst[node] + adj.weight) {
                dst[to] = dst[node] + adj.weight;
                edgeTo[to] = adj;

                for (Pair tmp : pq) {
                    // 更新之前的最短距离
                    if (tmp.index == to) {
                        pq.remove(tmp);
                        break;
                    }
                }
                pq.add(new Pair(to, dst[to]));
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

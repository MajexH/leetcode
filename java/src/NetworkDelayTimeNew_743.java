import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTimeNew_743 {

    private static class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    private static class Pair implements Comparable<Pair> {
        int node, weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return weight - o.weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // 理解这个问题 实际上是一个最长路径问题
        List<List<Edge>> map = new ArrayList<>(n);

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            map.get(edge[0]).add(new Edge(edge[0], edge[1], edge[2]));
        }

        // 要找到让所有节点都收到信号的结果
        int[] dstTo = new int[n + 1];
        Arrays.fill(dstTo, Integer.MAX_VALUE);
        dstTo[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k, 0));

        while (!pq.isEmpty()) {
            relax(pq, map, pq.poll().node, dstTo);
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            // 不可达
            if (dstTo[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, dstTo[i]);
        }

        return res;
    }

    private void relax(PriorityQueue<Pair> pq, List<List<Edge>> map, int node, int[] dstTo) {
        for (Edge adj : map.get(node)) {
            int to = adj.to;
            if (dstTo[to] > dstTo[node] + adj.weight) {
                dstTo[to] = dstTo[node] + adj.weight;
                pq.removeIf(tmp -> tmp.node == to);
                pq.add(new Pair(to, dstTo[to]));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new NetworkDelayTimeNew_743().networkDelayTime(new int[][]{
                {1,2,1},
                {2,3,2},
                {1,3,4}
        }, 3, 1));
        System.out.println(new NetworkDelayTimeNew_743().networkDelayTime(new int[][]{
                {1,2,1},
                {2,1,3}
        }, 2, 1));
        System.out.println(new NetworkDelayTimeNew_743().networkDelayTime(new int[][]{
                {1,2,1}
        }, 2, 2));
    }

}

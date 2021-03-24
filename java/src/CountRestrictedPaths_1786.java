import microsoft.PlusOne;

import java.util.*;

public class CountRestrictedPaths_1786 {

    private static class Edge {
        int from, to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int getOther(int node) {
            if (node == from) return to;
            return from;
        }
    }

    private static class Map {
        List<List<Edge>> map;
        public int capacity;

        public Map(int capacity) {
            this.capacity = capacity;
            this.map = new ArrayList<>();
            for (int i = 0; i < this.capacity; i++) {
                this.map.add(new ArrayList<>());
            }
        }

        public void addEdge(int from, int to, int weight) {
            Edge e = new Edge(from, to, weight);
            this.map.get(from).add(e);
            this.map.get(to).add(e);
        }

        public List<Edge> adj(int node) {
            return this.map.get(node);
        }
    }

    private static class Pair implements Comparable<Pair> {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return weight - o.weight;
        }
    }

    // 返回 dp 结果
    // 这个题目说的意思是 只要从尾结点开始遍历 并且到下一个点的距离 大于 当前点的距离 就是逆序的
    // 按照题解的描述
    // 这条路径的搜索过程可以看做，从结尾（第 5 个点）出发，逆着走，每次选择一个点（例如 a）之后，
    // 再选择下一个点（例如 b）时就必须满足最短路距离比上一个点（点 a）要远，如果最终能选到起点（第一个点），说明统计出一条有效路径。
    public int[] dijkstra(Map map, int start) {
        int[] dstTo = new int[map.capacity];
        Arrays.fill(dstTo, Integer.MAX_VALUE);
        dstTo[start] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(start, 0));

        // 无向图 防止重复
        boolean[] memo = new boolean[map.capacity];

        while (!queue.isEmpty()) {
            Pair top = queue.poll();
            memo[top.node] = true;
            for (Edge e : map.adj(top.node)) {
                int other = e.getOther(top.node);
                if (!memo[other] && dstTo[other] > dstTo[top.node] + e.weight) {
                    dstTo[other] = dstTo[top.node] + e.weight;
                    queue.removeIf((p) -> p.node == other);
                    queue.add(new Pair(other, dstTo[other]));
                }
            }
        }
        return dstTo;
    }

    public int countRestrictedPaths(int n, int[][] edges) {
        Map map = new Map(n + 1);

        for (int[] edge : edges) {
            map.addEdge(edge[0], edge[1], edge[2]);
        }

        // 返回节点的数据
        int[] dstTo = dijkstra(map, n);

        // 得到了dist数组，可以得到递推关系，dp[u] += dp[v], when v links to v and  dist[u] > dist[v]
        //        因此先算dist小的，才可以算dp，需要dist从小到大排序, 然后依次计算。
        // 保存到某个点 以及对应的 dst 距离
        List<int[]> pairs = new ArrayList<>();
        for (int i = 1; i < dstTo.length; i++) {
            pairs.add(new int[]{i, dstTo[i]});
        }
        pairs.sort(Comparator.comparingInt(a -> a[1]));

        int[] dp = new int[n + 1];
        dp[n] = 1;
        int mod = 1000000007;

        for (int[] p : pairs) {
            int node = p[0], cur = p[1];
            for (Edge adj : map.adj(node)) {
                int other = adj.getOther(node);
                if (cur > dstTo[other]) {
                    dp[node] = (dp[node] + dp[other]) % mod;
                }
            }
        }
        return dp[1];
    }

    public static void main(String[] args) {
        System.out.println(new CountRestrictedPaths_1786().countRestrictedPaths(5, new int[][]{
                {1, 2, 3},
                {1, 3, 3},
                {2, 3, 1},
                {1, 4, 2},
                {5, 2, 2},
                {3, 5, 1},
                {5, 4, 10}
        }));
        System.out.println(new CountRestrictedPaths_1786().countRestrictedPaths(7, new int[][]{
                {1, 3, 1},
                {4, 1, 2},
                {7, 3, 4},
                {2, 5, 3},
                {5, 6, 1},
                {6, 7, 2},
                {7, 5, 3},
                {2, 6, 4}
        }));
    }
}

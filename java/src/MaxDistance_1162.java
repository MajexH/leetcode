import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxDistance_1162 {


    public int maxDistance(int[][] grid) {
        // 考虑使用 dijkstra 算法
        // dijkstra 算法是找单源最短路经的
        // 因此在这儿要改造一下
        // 虚拟出一个超级节点 连接所有的起始节点 那样就可以找出从这个超级节点到 另外一个集合的最短距离

        int n = grid.length;
        int[][] dst = new int[n][n];
        // 无向图 为了防止重复访问 需要 memo
        boolean[][] memo = new boolean[n][n];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dst[i][j] = Integer.MAX_VALUE;
                // 连接到超级节点的 dst 为 0
                // 从 岸开始遍历 那么 岸到任意一个海的最短距离就会保存到 海节点上
                if (grid[i][j] == 1) {
                    dst[i][j] = 0;
                    pq.add(new Node(i, j, 0));
                }
            }
        }
        // 这样就可以吧时间复杂度降下来
        while (!pq.isEmpty()) {
            Node top = pq.poll();
            memo[top.x][top.y] = true;
            for (int[] direction : directions) {
                int newX = top.x + direction[0], newY = top.y + direction[1];
                // 越界
                if (newX >= n || newX < 0 || newY >= n || newY < 0) continue;
                if (memo[newX][newY]) continue;
                // relax
                if (dst[newX][newY] > dst[top.x][top.y] + 1) {
                    dst[newX][newY] = dst[top.x][top.y] + 1;
                    // 更新 pq 里面的最短距离
                    pq.removeIf((node) -> node.x == newX && node.y == newY);
                    pq.add(new Node(newX, newY, dst[newX][newY]));
                }
            }
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 因为结果保存在 海洋单元格内
                if (grid[i][j] == 0) res = Math.max(res, dst[i][j]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static class Node implements Comparable<Node> {
        int x, y;

        int dst;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            // 还没有找到
            this.dst = Integer.MAX_VALUE;
        }

        public Node(int x, int y, int dst) {
            this.x = x;
            this.y = y;
            this.dst = dst;
        }

        @Override
        public int compareTo(Node o) {
            return this.dst - o.dst;
        }
    }

    private static int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // 你现在手里有一份大小为 N x N 的 网格 grid，
    // 上面的每个 单元格 都用 0 和 1 标记好了。
    // 其中 0 代表海洋，1 代表陆地，请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。
    // 意思是可能有多个海洋单元格 找到这些海洋单元格最近的陆地单元格距离的 最大值
    // 距离的计算为 |x0 - x1| + |y0 - y1|
    // 这个算法 timeout 了 原因是因为相当于 o(n ^ 4) 的复杂度 是不科学的
    public int maxDistanceTimeout(int[][] grid) {
        int res = Integer.MIN_VALUE;
        int n = grid.length;
        Deque<Node> sea = new LinkedList<>();
        boolean[][] memo = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) sea.add(new Node(i, j));
            }
        }

        // 因为大小是 N * N 所以 直接从中间那个开始
        Deque<Node> queue = new LinkedList<>();

        queue.addLast(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node top = queue.removeFirst();
            memo[top.x][top.y] = true;
            // 海洋
            if (grid[top.x][top.y] == 1) {
                // 陆地
                // 更新 node
                for (Node s : sea) {
                    s.dst = Math.min(s.dst, calculateDistance(s.x, top.x, s.y, top.y));
                }
            }
            for (int[] direction : directions) {
                int newX = top.x + direction[0], newY = top.y + direction[1];
                // 越界
                if (newX >= n || newX < 0 || newY >= n || newY < 0 || memo[newX][newY]) continue;
                queue.add(new Node(newX, newY));
            }
        }

        for (Node t : sea) {
            res = Math.max(res, t.dst);
        }

        return res == Integer.MIN_VALUE || res == Integer.MAX_VALUE ? -1 : res;
    }

    public int calculateDistance(int x0, int x1, int y0, int y1) {
        return (x0 > x1 ? x0 - x1 : x1 - x0) + (y0 > y1 ? y0 - y1 : y1 - y0);
    }

    public static void main(String[] args) {
//        System.out.println(new MaxDistance_1162().maxDistance(new int[][]{
//                {1, 0, 1},
//                {0, 0, 0},
//                {1, 0, 1}
//        }));
//        System.out.println(new MaxDistance_1162().maxDistance(new int[][]{
//                {1, 0, 0},
//                {0, 0, 0},
//                {0, 0, 0}
//        }));
        System.out.println(new MaxDistance_1162().maxDistance(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        }));
    }
}

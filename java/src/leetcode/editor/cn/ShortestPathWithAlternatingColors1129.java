//在一个有向图中，节点分别标记为 0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。 
//
// red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从
//节点 i 到节点 j 的蓝色有向边。 
//
// 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，
//那么 answer[x] = -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
//输出：[0,1,-1]
// 
//
// 示例 2： 
//
// 
//输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
//输出：[0,1,-1]
// 
//
// 示例 3： 
//
// 
//输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
//输出：[0,-1,-1]
// 
//
// 示例 4： 
//
// 
//输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
//输出：[0,1,2]
// 
//
// 示例 5： 
//
// 
//输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
//输出：[0,1,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// red_edges.length <= 400 
// blue_edges.length <= 400 
// red_edges[i].length == blue_edges[i].length == 2 
// 0 <= red_edges[i][j], blue_edges[i][j] < n 
// 
//
// Related Topics 广度优先搜索 图 👍 196 👎 0


package leetcode.editor.cn;

import java.util.*;

public class ShortestPathWithAlternatingColors1129 {
    public static void main(String[] args) {
        Solution solution = new ShortestPathWithAlternatingColors1129().new Solution();

        // [0,1,-1]
        System.out.println(Arrays.toString(solution.shortestAlternatingPaths(3, new int[][]{{0, 1}, {1, 2}}, new int[0][0])));
        // [0,-1,-1]
        System.out.println(Arrays.toString(solution.shortestAlternatingPaths(3, new int[][]{{1, 0}}, new int[][]{{2, 1}})));
        // [0,1,2]
        System.out.println(Arrays.toString(solution.shortestAlternatingPaths(3, new int[][]{{0, 1}}, new int[][]{{1, 2}})));
        // [0, 1, -1]
        System.out.println(Arrays.toString(solution.shortestAlternatingPaths(3, new int[][]{{0, 1}}, new int[][]{{2, 1}})));
        // [0,1,2,3,7]
        System.out.println(Arrays.toString(solution.shortestAlternatingPaths(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, new int[][]{{1, 2}, {2, 3}, {3, 1}})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            Map<Integer, List<List<Integer>>> map = new HashMap<>();

            // 0 是红色边 1 是蓝色边
            for (int[] redEdge : redEdges) {
                map.computeIfAbsent(redEdge[0], key -> new ArrayList<>() {{
                    add(new ArrayList<>());
                    add(new ArrayList<>());
                }}).get(0).add(redEdge[1]);
            }

            for (int[] blueEdge : blueEdges) {
                map.computeIfAbsent(blueEdge[0], key -> new ArrayList<>() {{
                    add(new ArrayList<>());
                    add(new ArrayList<>());
                }}).get(1).add(blueEdge[1]);
            }

            int[] res = new int[n];

            for (int i = 1; i < n; i++) {
                res[i] = this.travel(map, 0, i);
            }

            return res;
        }

        private int travel(Map<Integer, List<List<Integer>>> map, int start, int end) {

            Deque<int[]> deque = new LinkedList<>();

            // 看当前节点是否访问过
            // 如果第二次访问到了 说明已经成环 需要跳过后续的节点处理
            Set<Pair> memo = new HashSet<>();
            // 最后一位是距离
            deque.add(new int[]{-1, start, 0});

            while (!deque.isEmpty()) {
                // 有向图 可能成环 要规避成环的问题
                int[] top = deque.removeFirst();
                memo.add(new Pair(top[0], top[1]));
                List<List<Integer>> edges = map.getOrDefault(top[1], new ArrayList<>());

                // 两种颜色都可以
                if (top[0] == -1) {
                    for (int i = 0; i < edges.size(); i++) {
                        for (int node : edges.get(i)) {
                            if (memo.contains(new Pair(i, node))) {
                                continue;
                            }
                            if (node == end) {
                                return top[2] + 1;
                            }
                            deque.addLast(new int[]{i, node, top[2] + 1});
                        }
                    }
                } else if (top[0] == 0) {
                    // 如果是红色 那么只能拿蓝色
                    if (edges.size() < 2) {
                        continue;
                    }
                    for (int node : edges.get(1)) {
                        if (memo.contains(new Pair(1, node))) {
                            continue;
                        }
                        if (node == end) {
                            return top[2] + 1;
                        }
                        deque.addLast(new int[]{1, node, top[2] + 1});
                    }
                } else {
                    // 如果是蓝色 那么只能拿红色
                    if (edges.size() < 1) {
                        continue;
                    }
                    for (int node : edges.get(0)) {
                        if (memo.contains(new Pair(0, node))) {
                            continue;
                        }
                        if (node == end) {
                            return top[2] + 1;
                        }
                        deque.addLast(new int[]{0, node, top[2] + 1});
                    }
                }
            }

            return -1;
        }

        private static final class Pair {
            private int color;
            private int node;

            public Pair(int color, int node) {
                this.color = color;
                this.node = node;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Pair pair = (Pair) o;
                return color == pair.color && node == pair.node;
            }

            @Override
            public int hashCode() {
                return Objects.hash(color, node);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
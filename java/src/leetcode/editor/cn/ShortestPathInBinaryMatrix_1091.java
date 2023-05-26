//给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
//
// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求
//： 
//
// 
// 路径途经的所有单元格都的值都是 0 。 
// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。 
// 
//
// 畅通路径的长度 是该路径途经的单元格总数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,1],[1,0]]
//输出：2
// 
//
// 示例 2： 
// 
// 
//输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 287 👎 0


package src.leetcode.editor.cn;

import java.util.*;

public class ShortestPathInBinaryMatrix_1091 {
    public static void main(String[] args) {
        Solution solution = new ShortestPathInBinaryMatrix_1091().new Solution();

        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0}}));
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{
                {0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 0},
                {1, 1, 1, 1, 0}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int[][] DIRECTIONS = new int[][]{
                {0, 1}, {0, -1}, {1, 0}, {-1, 0},
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };

        public int shortestPathBinaryMatrix(int[][] grid) {

            Deque<Trace> traces = new LinkedList<>();
            Set<Trace> traveled = new HashSet<>();

            // 开始和结束 是 1 就不用再看了
            if (grid[0][0] == 1 || grid[grid.length - 1][grid[grid.length - 1].length - 1] == 1) {
                return -1;
            }

            Trace start = new Trace(0, 0, 1);
            traces.addLast(start);
            traveled.add(start);

            while (!traces.isEmpty()) {

                Trace cur = traces.pollFirst();

                if (Objects.equals(cur.x, grid.length - 1)
                        && Objects.equals(cur.y, grid[cur.x].length - 1)) {
                    return cur.distance;
                }

                // 遍历 8 个方向
                for (int[] direction : DIRECTIONS) {
                    int newX = cur.x + direction[0];
                    int newY = cur.y + direction[1];

                    Trace next = new Trace(newX, newY, cur.distance + 1);
                    // 已经访问过
                    if (traveled.contains(next)) {
                        continue;
                    }
                    traveled.add(next);
                    // x 不满足
                    if (newX >= grid.length || newX < 0) {
                        continue;
                    }
                    if (newY >= grid[newX].length || newY < 0) {
                        continue;
                    }
                    if (grid[newX][newY] != 0) {
                        continue;
                    }


                    if (Objects.equals(newX, grid.length - 1)
                            && Objects.equals(newY, grid[cur.x].length - 1)) {
                        return next.distance;
                    }

                    // 剩下的都是满足的
                    traces.addLast(next);

                }
            }

            return -1;
        }

        private static final class Trace {
            int x, y;
            int distance;

            public Trace(int x, int y, int distance) {
                this.x = x;
                this.y = y;
                this.distance = distance;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Trace trace = (Trace) o;
                return x == trace.x && y == trace.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
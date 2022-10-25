//给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。 
//
// 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。 
//
// 
// 
// 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。 
// 
// 
//
// 返回必须翻转的 0 的最小数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[1,0]]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 2 <= n <= 100 
// grid[i][j] 为 0 或 1 
// grid 中恰有两个岛 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 310 👎 0


package leetcode.editor.cn;

import java.util.*;

public class ShortestBridge934 {
    public static void main(String[] args) {
        Solution solution = new ShortestBridge934().new Solution();
        System.out.println(solution.shortestBridge(new int[][]{{0, 1}, {1, 0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        public int shortestBridge(int[][] grid) {

            if (Objects.isNull(grid) || Objects.isNull(grid[0])) {
                return 0;
            }

            List<int[]> islandOne = new ArrayList<>();
            // 从第一个岛广搜 找到第二个岛的最短路径
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    // 如果当前是 1 说明要广搜找到第一个岛
                    if (grid[i][j] == 1) {
                        // 广搜找到第一个岛
                        this.bfsBuild(grid, i, j, islandOne);

                        // 直接在所有的结果上 bfs
                        return this.bfsFind(grid, islandOne) - 1;
                    }
                }
            }

            return -1;
        }

        public int bfsFind(int[][] grid, List<int[]> idlandOne) {
            Deque<Triple> stack = new LinkedList<>();

            for (int[] pair : idlandOne) {
                stack.addLast(new Triple(pair[0], pair[1], 0));
            }

            while (!stack.isEmpty()) {

                Triple first = stack.removeFirst();
                int i = first.i, j = first.j;

                for (int[] direction : directions) {
                    int ni = i + direction[0], nj = j + direction[1];
                    if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[ni].length) {
                        continue;
                    }
                    if (grid[ni][nj] == 0) {
                        stack.addLast(new Triple(ni, nj, first.index + 1));
                        // 标识已经访问过
                        grid[ni][nj] = -1;
                    } else if (grid[ni][nj] == 1) {
                        return first.index + 1;
                    }
                }

            }

            return Integer.MAX_VALUE;
        }

        public void bfsBuild(int[][] grid, int startI, int startJ, List<int[]> isLandOne) {
            Deque<Pair> stack = new LinkedList<>();
            stack.addLast(new Pair(startI, startJ));
            grid[startI][startJ] = -1;
            while (!stack.isEmpty()) {
                Pair first = stack.removeFirst();
                int i = first.i, j = first.j;
                isLandOne.add(new int[]{i, j});
                // 改成 -1 表示遍历过了
                for (int[] direction : directions) {
                    int ni = i + direction[0], nj = j + direction[1];
                    if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[ni].length || grid[ni][nj] != 1) {
                        continue;
                    }
                    stack.addLast(new Pair(ni, nj));
                    grid[ni][nj] = -1;
                }
            }
        }

        private static final class Pair {
            int i, j;

            public Pair(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }

        private static final class Triple {
            int i, j, index;

            public Triple(int i, int j, int index) {
                this.i = i;
                this.j = j;
                this.index = index;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
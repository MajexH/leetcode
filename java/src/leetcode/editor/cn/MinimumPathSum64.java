package leetcode.editor.cn;//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 👍 1284 👎 0


public class MinimumPathSum64 {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum64().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int[][] dp = new int[grid.length][];

            for (int i = 0; i < grid.length; i++) {
                dp[i] = new int[grid[i].length];
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = grid[0][0];
                        continue;
                    }

                    dp[i][j] = grid[i][j] + Math.min(i - 1 >= 0 ? dp[i - 1][j] : Integer.MAX_VALUE, j - 1 >= 0 ? dp[i][j - 1] : Integer.MAX_VALUE);
                }
            }

            return dp[grid.length - 1][grid[grid.length - 1].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
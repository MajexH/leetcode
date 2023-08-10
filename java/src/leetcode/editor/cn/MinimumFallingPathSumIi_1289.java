//给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
//
// 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
//输出：13
//解释：
//所有非零偏移下降路径包括：
//[1,5,9], [1,5,7], [1,6,7], [1,6,8],
//[2,4,8], [2,4,9], [2,6,7], [2,6,8],
//[3,4,8], [3,4,9], [3,5,7], [3,5,9]
//下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[7]]
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 200 
// -99 <= grid[i][j] <= 99 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 130 👎 0


package leetcode.editor.cn;

import java.util.Objects;

public class MinimumFallingPathSumIi_1289 {
    public static void main(String[] args) {
        Solution solution = new MinimumFallingPathSumIi_1289().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] grid) {
            int n = grid.length;
            int first_min_sum = 0;
            int second_min_sum = 0;
            int first_min_index = -1;

            for (int i = 0; i < n; i++) {
                int cur_first_min_sum = Integer.MAX_VALUE;
                int cur_second_min_sum = Integer.MAX_VALUE;
                int cur_first_min_index = -1;

                for (int j = 0; j < n; j++) {
                    int cur_sum = (j != first_min_index ? first_min_sum : second_min_sum) + grid[i][j];
                    if (cur_sum < cur_first_min_sum) {
                        cur_second_min_sum = cur_first_min_sum;
                        cur_first_min_sum = cur_sum;
                        cur_first_min_index = j;
                    } else if (cur_sum < cur_second_min_sum) {
                        cur_second_min_sum = cur_sum;
                    }
                }
                first_min_sum = cur_first_min_sum;
                second_min_sum = cur_second_min_sum;
                first_min_index = cur_first_min_index;
            }
            return first_min_sum;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
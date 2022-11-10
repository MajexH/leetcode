//在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示
//grid[xi][yi] == 0 
//
// 返回 grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。 
//
// 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，
//由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: n = 5, mines = [[4, 2]]
//输出: 2
//解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
// 
//
// 示例 2： 
//
// 
//
// 
//输入: n = 1, mines = [[0, 0]]
//输出: 0
//解释: 没有加号标志，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 500 
// 1 <= mines.length <= 5000 
// 0 <= xi, yi < n 
// 每一对 (xi, yi) 都 不重复 
// 
//
// Related Topics 数组 动态规划 👍 196 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class LargestPlusSign764 {
    public static void main(String[] args) {
        Solution solution = new LargestPlusSign764().new Solution();
        System.out.println(solution.orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orderOfLargestPlusSign(int n, int[][] mines) {

            int[][] array = new int[n][];

            for (int i = 0; i < n; i++) {
                array[i] = new int[n];
                Arrays.fill(array[i], 1);
            }

            for (int[] mine : mines) {
                array[mine[0]][mine[1]] = 0;
            }

            int[][] left = new int[n][n], right = new int[n][n];
            int[][] up = new int[n][n], down = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (array[i][j] == 0) {
                        left[i][j] = 0;
                    } else {
                        left[i][j] = j > 0 ? left[i][j - 1] + 1 : 1;
                    }
                }

                for (int j = n - 1; j >= 0; j--) {
                    if (array[i][j] == 0) {
                        right[i][j] = 0;
                    } else {
                        right[i][j] = j < n - 1 ? right[i][j + 1] + 1 : 1;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (array[i][j] == 0) {
                        up[i][j] = 0;
                    } else {
                        up[i][j] = i - 1 >= 0 ? up[i - 1][j] + 1 : 1;
                    }
                }

                for (int i = n - 1; i >= 0; i--) {
                    if (array[i][j] == 0) {
                        down[i][j] = 0;
                    } else {
                        down[i][j] = i + 1 < n ? down[i + 1][j] + 1 : 1;
                    }
                }
            }

            int res = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res = Math.max(res, Math.min(Math.min(left[i][j], right[i][j]), Math.min(up[i][j], down[i][j])));
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
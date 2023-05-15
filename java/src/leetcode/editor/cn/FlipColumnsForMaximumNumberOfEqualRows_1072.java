//给定 m x n 矩阵 matrix 。
//
// 你可以从中选出任意数量的列并翻转其上的 每个 单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。） 
//
// 返回 经过一些翻转后，行与行之间所有值都相等的最大行数 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[0,1],[1,1]]
//输出：1
//解释：不进行翻转，有 1 行所有值都相等。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[0,1],[1,0]]
//输出：2
//解释：翻转第一列的值之后，这两行都由相等的值组成。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[0,0,0],[0,0,1],[1,1,0]]
//输出：2
//解释：翻转前两列的值之后，后两行由相等的值组成。 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] == 0 或 1 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 118 👎 0


package src.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaximumNumberOfEqualRows_1072 {
    public static void main(String[] args) {
        Solution solution = new FlipColumnsForMaximumNumberOfEqualRows_1072().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            // 001 110 是本质相同的列 因为 001 -> 111  110 -> 000 都是翻转第一列和第二列 所以是一样的

            Map<String, Integer> counterMap = new HashMap<>();

            for (int i = 0; i < matrix.length; i++) {
                int[] row = matrix[i];
                if (row[0] == 1) {
                    // reverse
                    row = this.reverse(row);
                }

                String key = Arrays.toString(row);
                counterMap.put(key, counterMap.getOrDefault(key, 0) + 1);
            }

            int res = 0;
            for (Integer counter : counterMap.values()) {
                res = Math.max(counter, res);
            }

            return res;
        }

        private int[] reverse(int[] num) {

            int[] res = new int[num.length];

            for (int i = 0; i < num.length; i++) {
                if (num[i] == 0) {
                    res[i] = 1;
                } else {
                    res[i] = 0;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
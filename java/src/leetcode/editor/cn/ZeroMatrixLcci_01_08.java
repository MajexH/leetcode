//<p>编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//<strong>输出：</strong>
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//<strong>输出：</strong>
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
//</pre>
//
//<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>矩阵</li></div></div><br><div><li>👍 119</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Objects;

public class ZeroMatrixLcci_01_08 {
    public static void main(String[] args) {
        Solution solution = new ZeroMatrixLcci_01_08().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            if (Objects.isNull(matrix) || matrix.length == 0) {
                return;
            }
            int[] row = new int[matrix.length], column = new int[matrix[0].length];

            Arrays.fill(row, -1);
            Arrays.fill(column, -1);

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = 0;
                        column[j] = 0;
                    }
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (row[i] == 0 || column[j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
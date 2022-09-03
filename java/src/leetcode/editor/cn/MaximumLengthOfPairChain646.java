//给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
//
// 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。 
//
// 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。 
//
// 
//
// 示例： 
//
// 
//输入：[[1,2], [2,3], [3,4]]
//输出：2
//解释：最长的数对链是 [1,2] -> [3,4]
// 
//
// 
//
// 提示： 
//
// 
// 给出数对的个数在 [1, 1000] 范围内。 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 325 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class MaximumLengthOfPairChain646 {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfPairChain646().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLongestChain(int[][] pairs) {

            Arrays.sort(pairs, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });

            int[] dp = new int[pairs.length];

            Arrays.fill(dp, 1);
            int res = 1;

            for (int i = 0; i < pairs.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (pairs[i][0] > pairs[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(res, dp[i]);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
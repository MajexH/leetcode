//给定一个未排序的整数数组
// nums ， 返回最长递增子序列的个数 。 
//
// 注意 这个数列必须是 严格 递增的。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 
//
// 提示: 
//
// 
// 
//
// 
// 1 <= nums.length <= 2000 
// -10⁶ <= nums[i] <= 10⁶ 
// 
//
// Related Topics 树状数组 线段树 数组 动态规划 👍 705 👎 0


package leetcode.editor.cn;

public class NumberOfLongestIncreasingSubsequence673 {
    public static void main(String[] args) {
        Solution solution = new NumberOfLongestIncreasingSubsequence673().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findNumberOfLIS(int[] nums) {
            Pair[] dp = new Pair[nums.length];

            for (int i = 0; i < nums.length; i++) {
                dp[i] = new Pair(1, 1);
            }

            int maxLen = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    // 如果可以的话
                    if (nums[j] < nums[i]) {
                        if (dp[j].len >= dp[i].len) {
                            dp[i].counter = dp[j].counter;
                            dp[i].len = dp[j].len + 1;
                        } else if (dp[j].len + 1 == dp[i].len) {
                            dp[i].counter += dp[j].counter;
                        }
                    }
                }
                maxLen = Math.max(maxLen, dp[i].len);
            }

            int res = 0;

            for (int i = 0; i < dp.length; i++) {
                if (dp[i].len == maxLen) {
                    res += dp[i].counter;
                }
            }

            return res;
        }

        private static final class Pair {
            private int len;
            private int counter;

            public Pair(int len, int counter) {
                this.len = len;
                this.counter = counter;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
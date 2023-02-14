//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 示例 2： 
//
// 
//输入：hours = [6,6,6]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10⁴ 
// 0 <= hours[i] <= 16 
// 
//
// Related Topics 栈 数组 哈希表 前缀和 单调栈 👍 319 👎 0


package leetcode.editor.cn;

public class LongestWellPerformingInterval1124 {
    public static void main(String[] args) {
        Solution solution = new LongestWellPerformingInterval1124().new Solution();
        System.out.println(solution.longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
        System.out.println(solution.longestWPI(new int[]{6, 6, 6}));
        System.out.println(solution.longestWPI(new int[]{6, 6, 9}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestWPI(int[] hours) {

            Pair[] dp = new Pair[hours.length + 1];
            dp[0] = new Pair(0, 0);

            for (int i = 1; i <= hours.length; i++) {
                Pair pre = dp[i - 1];
                dp[i] = new Pair(pre.good + (hours[i - 1] > 8 ? 1 : 0), pre.bad + (hours[i - 1] <= 8 ? 1 : 0));
            }

            int res = 0;
            for (int i = 1; i <= hours.length; i++) {
                for (int j = 0; j <= i; j++) {
                    int goodDiff = dp[i].good - dp[j].good;
                    int badDiff = dp[i].bad - dp[j].bad;
                    if (goodDiff > badDiff) {
                        res = Math.max(res, i - j);
                    }
                }
            }

            return res;
        }

        private static final class Pair {
            private int good;
            private int bad;

            public Pair(int good, int bad) {
                this.good = good;
                this.bad = bad;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
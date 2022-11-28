//给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个相邻的非空子数组 。 分数 由每个子数组内的平均值的总和构成。
//
// 注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。 
//
// 返回我们所能得到的最大 分数 是多少。答案误差在 10⁻⁶ 内被视为是正确的。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [9,1,2,3,9], k = 3
//输出: 20.00000
//解释: 
//nums 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20. 
//我们也可以把 nums 分成[9, 1], [2], [3, 9]. 
//这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 4
//输出: 20.50000
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 数组 动态规划 前缀和 👍 268 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestSumOfAverages813 {
    public static void main(String[] args) {
        Solution solution = new LargestSumOfAverages813().new Solution();
        System.out.println(solution.largestSumOfAverages(new int[]{1}, 1));
        System.out.println(solution.largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3));
        System.out.println(solution.largestSumOfAverages(new int[]{1, 2, 3, 4, 5, 6, 7}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private double res = 0D;

        public double largestSumOfAverages(int[] nums, int k) {

            int[] preSum = new int[nums.length + 1];

            for (int i = 1; i <= nums.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }

            double[][] dp = new double[nums.length + 1][k + 1];

            for (int i = 1; i <= nums.length; i++) {
                // 初始化 k == 1 时 就是 0 -> i 的合的平均值
                dp[i][1] = preSum[i] / (i * 1D);
            }

            // i 已经初始化
            for (int j = 2; j <= k; j++) {
                // 把之前一轮的计算完毕了再计算下面一个
                for (int i = 1; i <= nums.length; i++) {
                    for (int split = 0; split < i; split++) {
                        // 少分隔一次
                        // 分隔点之后的平均值
                        dp[i][j] = Math.max(dp[i][j], dp[split][j - 1] + (preSum[i] - preSum[split]) * 1D / (i - split));
                    }
                }
            }

            return dp[nums.length][k];
        }

        public double largestSumOfAveragesUsingOrNotUsing(int[] nums, int k) {
            res = 0D;

            // 包含 i 所指示的数
            int[] preSum = new int[nums.length];
            preSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i];
            }

            if (k == 1) {
                return preSum[nums.length - 1] / (double) nums.length;
            }

            double[][] memo = new double[nums.length][k + 1];
            for (int i = 0; i < nums.length; i++) {
                memo[i] = new double[k + 1];
                Arrays.fill(memo[i], -1);
            }
            // 要或者不要 导致的问题是 2^n * k 的查询效率 比较低
            this.recursionUsingOrNotUsing(preSum, k, 0, nums.length, new ArrayList<>());

            return res;
        }

        private void recursionUsingOrNotUsing(int[] preSum, int k, int start, int length, List<Integer> ends) {
            // 还剩一个了 要把 start 到 nums 结尾的全部算上
            if (k == 1) {
                double sum = preSum[ends.get(0)] / (ends.get(0) + 1D);
                ends.add(length - 1);

                for (int i = 1; i < ends.size(); i++) {
                    int end = ends.get(i), pre = ends.get(i - 1);
                    sum += (preSum[end] - preSum[pre]) / (double) (end - pre);
                }
                res = Math.max(res, sum);
                ends.remove(ends.size() - 1);
                return;
            }
            // 遍历不同的分隔方法
            for (int i = start; i < length - 1; i++) {
                ends.add(i);
                this.recursionUsingOrNotUsing(preSum, k - 1, i + 1, length, ends);
                ends.remove(ends.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
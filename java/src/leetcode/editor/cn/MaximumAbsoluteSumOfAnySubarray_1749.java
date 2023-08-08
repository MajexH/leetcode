//给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(
//numsl + numsl+1 + ... + numsr-1 + numsr) 。 
//
// 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。 
//
// abs(x) 定义如下： 
//
// 
// 如果 x 是负整数，那么 abs(x) = -x 。 
// 如果 x 是非负整数，那么 abs(x) = x 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-3,2,3,-4]
//输出：5
//解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,-5,1,-4,3,-2]
//输出：8
//解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 动态规划 👍 44 👎 0


package leetcode.editor.cn;

public class MaximumAbsoluteSumOfAnySubarray_1749 {
    public static void main(String[] args) {
        Solution solution = new MaximumAbsoluteSumOfAnySubarray_1749().new Solution();
        System.out.println(solution.maxAbsoluteSum(new int[]{1, -3, 2, 3, -4}));
        System.out.println(solution.maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxAbsoluteSum(int[] nums) {

            int positiveMax = 0, positiveSum = 0;
            int negativeMin = 0, negativeSum = 0;

            for (int num : nums) {

                positiveSum += num;
                positiveMax = Math.max(positiveMax, positiveSum);
                // 如果小于了 说明要从下一个 num 从新计数
                positiveSum = Math.max(positiveSum, 0);

                negativeSum += num;
                negativeMin = Math.min(negativeMin, negativeSum);
                negativeSum = Math.min(negativeSum, 0);
            }

            return Math.max(positiveMax, -negativeMin);
        }

        // o(n^2) 的方法 有问题
        public int maxAbsoluteSumBruteForce(int[] nums) {
            int res = 0;

            int[] sum = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }

            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    int tmp = sum[j + 1] - sum[i];
                    res = Math.max(Math.abs(tmp), res);
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
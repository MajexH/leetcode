//给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）： 
//
// 
// nums.length == n 
// nums[i] 是 正整数 ，其中 0 <= i < n 
// abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1 
// nums 中所有元素之和不超过 maxSum 
// nums[index] 的值被 最大化 
// 
//
// 返回你所构造的数组中的 nums[index] 。 
//
// 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4, index = 2,  maxSum = 6
//输出：2
//解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
// 
//
// 示例 2： 
//
// 输入：n = 6, index = 1,  maxSum = 10
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= maxSum <= 10⁹ 
// 0 <= index < n 
// 
//
// Related Topics 贪心 二分查找 👍 96 👎 0


package leetcode.editor.cn;

public class MaximumValueAtAGivenIndexInABoundedArray1802 {
    public static void main(String[] args) {
        Solution solution = new MaximumValueAtAGivenIndexInABoundedArray1802().new Solution();
//        System.out.println(solution.maxValue(4, 2, 6));
//        System.out.println(solution.maxValue(6, 1, 10));
//        // 4
//        System.out.println(solution.maxValue(8, 7, 14));
        // 1
        System.out.println(solution.maxValue(4, 0, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxValue(int n, int index, int maxSum) {

            int left = 1, right = maxSum;

            while (left < right) {
                // 向上滑动一位
                int mid = (left + right + 1) / 2;

                if (this.valid(index, mid, n, maxSum)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            return left;
        }

        // 现在就看所有的数据加起来是不是大于 maxSum
        // 最小的和可能是 除了 index 位置的是最大的数 mid 外，其余的数依次递减为 1 直到介绍的数为 1 为止
        private boolean valid(int index, int mid, int n, int maxSum) {

            return mid + this.calculate(mid, index) + this.calculate(mid, n - 1 - index) <= maxSum;
        }

        private long calculate(int big, int len) {

            // 如果左边的数 可以减到 1
            if (len + 1 <= big) {
                return (long) (big - 1 + big - len) * len / 2L;
            }
            // 如果左边的数 减到比 1 小了
            // 说明剩下的有一部分长度需要直接加上 1
            return (long) (big - 1) * big / 2L + (len + 1 - big);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
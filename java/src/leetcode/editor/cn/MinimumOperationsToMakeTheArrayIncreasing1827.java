//给你一个整数数组 nums （下标从 0 开始）。每一次操作中，你可以选择数组中一个元素，并将它增加 1 。 
//
// 
// 比方说，如果 nums = [1,2,3] ，你可以选择增加 nums[1] 得到 nums = [1,3,3] 。 
// 
//
// 请你返回使 nums 严格递增 的 最少 操作次数。 
//
// 我们称数组 nums 是 严格递增的 ，当它满足对于所有的 0 <= i < nums.length - 1 都有 nums[i] < nums[i+1]
// 。一个长度为 1 的数组是严格递增的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,1]
//输出：3
//解释：你可以进行如下操作：
//1) 增加 nums[2] ，数组变为 [1,1,2] 。
//2) 增加 nums[1] ，数组变为 [1,2,2] 。
//3) 增加 nums[2] ，数组变为 [1,2,3] 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,5,2,4,1]
//输出：14
// 
//
// 示例 3： 
//
// 输入：nums = [8]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// 1 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 👍 51 👎 0


package leetcode.editor.cn;

public class MinimumOperationsToMakeTheArrayIncreasing1827 {
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToMakeTheArrayIncreasing1827().new Solution();
        System.out.println(solution.minOperations(new int[]{1, 1, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minOperations(int[] nums) {

            int res = 0;

            int expected = nums[0] + 1;

            for (int i = 1; i < nums.length; i++) {
                // 比 tmp 大 说明不用累加
                if (nums[i] >= expected) {
                    expected = nums[i] + 1;
                    continue;
                }

                res += expected - nums[i];
                expected = expected + 1;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
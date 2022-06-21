////给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
////
//// 子数组 是数组中的一个连续部分。
////
////
////
//// 示例 1：
////
////
////输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
////输出：6
////解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
////
////
//// 示例 2：
////
////
////输入：nums = [1]
////输出：1
////
////
//// 示例 3：
////
////
////输入：nums = [5,4,-1,7,8]
////输出：23
////
////
////
////
//// 提示：
////
////
//// 1 <= nums.length <= 10⁵
//// -10⁴ <= nums[i] <= 10⁴
////
////
////
////
//// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
//// Related Topics 数组 分治 动态规划 👍 4973 👎 0
//
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int maxSubArray(int[] nums) {
//        int res = Integer.MIN_VALUE, tmp = 0;
//
//        for (int num : nums) {
//            if (tmp < 0) {
//                tmp = num;
//            } else {
//                tmp += num;
//            }
//            res = Math.max(res, tmp);
//        }
//
//        return res;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)

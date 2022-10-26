//给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 
//-1 。 
//
// 子数组 是数组中 连续 的一部分。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2], k = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-1,2], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁵ <= nums[i] <= 10⁵ 
// 1 <= k <= 10⁹ 
// 
//
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 👍 482 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarrayWithSumAtLeastK862 {
    public static void main(String[] args) {
        Solution solution = new ShortestSubarrayWithSumAtLeastK862().new Solution();
        System.out.println(solution.shortestSubarray(new int[]{17,85,93,-45,-21}, 150));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            long[] preSums = new long[nums.length + 1];

            for (int i = 0; i < nums.length; i++) {
                preSums[i + 1] = preSums[i] + nums[i];
            }

            int res = Integer.MAX_VALUE;

            // 直接遍历所有的可能超时
//            for (int i = 0; i <= nums.length; i++) {
//                for (int j = i - 1; j >= 0; j--) {
//                    if (preSums[i] - preSums[j] >= k) {
//                        res = Math.min(res, i - j);
//                        break;
//                    }
//                }
//            }

            // 优化超时时间
            // 其实所有的结果里面有些可以剪枝的部分
            // 1. 如果当前的遍历的时候 已经减去大于等于 k 了 说明后续的已经不可能比它小了 应该停止
            // 2. 应该弹出所有大于当前要压栈的前缀和 因为如果后续有一个新的数值遍历到这个地方时候 如果不满足 只有后续的前缀和比当前的小 才可能满足大于等于 k
            // 保存前缀和的 id
            Deque<Integer> queue = new LinkedList<>();

            for (int i = 0; i <= nums.length; i++) {

                while (!queue.isEmpty() && preSums[i] - preSums[queue.peekFirst()] >= k) {
                    res = Math.min(res, i - queue.pollFirst());
                }

                while (!queue.isEmpty() && preSums[i] <= preSums[queue.peekLast()]) {
                    queue.pollLast();
                }

                queue.addLast(i);
            }

            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
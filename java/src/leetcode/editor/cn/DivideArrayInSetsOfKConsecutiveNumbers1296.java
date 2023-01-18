//给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。 如果可以，请返回 true；否则，返回 
//false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,3,4,4,5,6], k = 4
//输出：true
//解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
//输出：true
//解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3,2,2,1,1], k = 3
//输出：true
// 
//
// 示例 4： 
//
// 
//输入：nums = [1,2,3,4], k = 3
//输出：false
//解释：数组不能分成几个大小为 3 的子数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 
//
// 注意：此题目与 846 重复：https://leetcode-cn.com/problems/hand-of-straights/ 
//
// Related Topics 贪心 数组 哈希表 排序 👍 84 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class DivideArrayInSetsOfKConsecutiveNumbers1296 {
    public static void main(String[] args) {
        Solution solution = new DivideArrayInSetsOfKConsecutiveNumbers1296().new Solution();
        System.out.println(solution.isPossibleDivide(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4));
        System.out.println(solution.isPossibleDivide(new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11}, 3));
        System.out.println(solution.isPossibleDivide(new int[]{3, 3, 2, 2, 1, 1}, 3));
        System.out.println(solution.isPossibleDivide(new int[]{1, 2, 3, 4}, 3));
        System.out.println(solution.isPossibleDivide(new int[]{2, 3, 8, 11}, 2)); //false
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossibleDivide(int[] nums, int k) {

            if (nums.length % k != 0) {
                return false;
            }

            PriorityQueue<Integer> queue = Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toCollection(PriorityQueue::new));

            Map<Integer, Integer> memo = new HashMap<>();

            for (int num : nums) {
                memo.put(num, memo.getOrDefault(num, 0) + 1);
            }

            // 每次拿 k 个最小的
            while (!queue.isEmpty()) {
                int min = queue.peek();
                int counter = 0;
                while (counter < k) {
                    if (!memo.containsKey(min) || memo.get(min) == 0) {
                        return false;
                    }
                    memo.put(min, memo.get(min) - 1);
                    queue.remove(min);
                    min++;
                    counter++;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
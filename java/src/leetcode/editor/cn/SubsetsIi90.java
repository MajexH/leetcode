package src.leetcode.editor.cn;//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 位运算 数组 回溯 👍 869 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIi90 {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi90().new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        private boolean canRecursion(int start, int end, int[] nums) {
            for (int i = start; i < end; i++) {
                if (nums[i] == nums[end]) {
                    return false;
                }
            }
            return true;
        }

        private void recursion(List<List<Integer>> res, List<Integer> tmp, int start, int[] nums) {
            res.add(new ArrayList<>(tmp));

            for (int i = start; i < nums.length; i++) {
                if (this.canRecursion(start, i, nums)) {
                    tmp.add(nums[i]);
                    this.recursion(res, tmp, i + 1, nums);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }
            Arrays.sort(nums);

            List<List<Integer>> res = new ArrayList<>();
            this.recursion(res, new ArrayList<>(), 0, nums);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
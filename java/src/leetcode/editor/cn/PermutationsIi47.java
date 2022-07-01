package leetcode.editor.cn;//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 1109 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationsIi47 {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi47().new Solution();
        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private void recursion(List<List<Integer>> res, int start, int[] nums) {
            if (start == nums.length) {
                res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                if (canPermute(nums, start, i)) {
                    this.swap(nums, start, i);
                    this.recursion(res, start + 1, nums);
                    this.swap(nums, start, i);
                }
            }
        }

        private boolean canPermute(int[] nums, int start, int end) {
            for (int i = start; i <= end - 1; i++) {
                if (nums[i] == nums[end]) {
                    return false;
                }
            }
            return true;
        }

        private void swap(int[] nums, int i, int j) {
            if (nums[i] == nums[j]) {
                return;
            }
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            this.recursion(res, 0, nums);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
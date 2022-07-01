package leetcode.editor.cn;//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 2090 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations46 {
    public static void main(String[] args) {
        Solution solution = new Permutations46().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private void recursion(List<List<Integer>> res, int start, int[] nums) {

            if (start == nums.length) {
                res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                return;
            }

            for (int i = start; i < nums.length; i++) {
                this.swap(nums, i, start);
                this.recursion(res, start + 1, nums);
                this.swap(nums, i, start);
            }
        }

        private void swap(int[] nums, int i, int j) {
            if (nums[i] == nums[j]) {
                return;
            }
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            this.recursion(res, 0, nums);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
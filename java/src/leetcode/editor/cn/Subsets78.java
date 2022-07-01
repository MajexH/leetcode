package leetcode.editor.cn;//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1691 👎 0


import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {
        Solution solution = new Subsets78().new Solution();
        System.out.println(solution.subsets(new int[]{1,2,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private void recursion(List<Integer> tmp, int[] nums, int start, List<List<Integer>> res) {
            res.add(new ArrayList<>(tmp));

            if (start >= nums.length) {
                return;
            }

            for (int i = start; i < nums.length; i++) {
                tmp.add(nums[i]);
                this.recursion(tmp, nums, i + 1, res);
                tmp.remove(tmp.size() - 1);
            }
        }

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            this.recursion(new ArrayList<>(), nums, 0, res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
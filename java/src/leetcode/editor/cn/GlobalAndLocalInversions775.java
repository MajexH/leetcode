//给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。
//
// 全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目： 
//
// 
// 0 <= i < j < n 
// nums[i] > nums[j] 
// 
//
// 局部倒置 的数目等于满足下述条件的下标 i 的数目： 
//
// 
// 0 <= i < n - 1 
// nums[i] > nums[i + 1] 
// 
//
// 当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,2]
//输出：true
//解释：有 1 个全局倒置，和 1 个局部倒置。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,0]
//输出：false
//解释：有 2 个全局倒置，和 1 个局部倒置。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 0 <= nums[i] < n 
// nums 中的所有整数 互不相同 
// nums 是范围 [0, n - 1] 内所有数字组成的一个排列 
// 
//
// Related Topics 数组 数学 👍 157 👎 0


package leetcode.editor.cn;

import java.util.Objects;
import java.util.TreeSet;

public class GlobalAndLocalInversions775 {
    public static void main(String[] args) {
        Solution solution = new GlobalAndLocalInversions775().new Solution();
//        System.out.println(solution.isIdealPermutation(new int[]{1, 0, 2}));
//        System.out.println(solution.isIdealPermutation(new int[]{1, 2, 0}));
        System.out.println(solution.isIdealPermutation(new int[]{2, 0, 1})); // false
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isIdealPermutation(int[] nums) {

            // 局部倒序 是 全局倒序 的子集
            // 那么其实就只需要知道 是否有超过局部倒序的全局倒序的部分

            int n = nums.length, minSuff = nums[n - 1];
            for (int i = n - 3; i >= 0; i--) {
                if (nums[i] > minSuff) {
                    return false;
                }
                minSuff = Math.min(minSuff, nums[i + 1]);
            }

            return true;
        }

        public boolean isIdealPermutationBruteForce(int[] nums) {

            int global = 0, local = 0;

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {

                    if (nums[i] > nums[j]) {
                        local++;
                        if (i + 1 == j) {
                            global++;
                        }
                    }
                }
            }

            return global == local;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
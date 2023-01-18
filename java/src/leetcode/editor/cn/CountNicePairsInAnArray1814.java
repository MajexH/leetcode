//给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， 
//rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ： 
//
// 
// 0 <= i < j < nums.length 
// nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) 
// 
//
// 请你返回好下标对的数目。由于结果可能会很大，请将结果对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [42,11,1,97]
//输出：2
//解释：两个坐标对为：
// - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
// - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
// 
//
// 示例 2： 
//
// 输入：nums = [13,10,35,24,76]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 数学 计数 👍 92 👎 0


package leetcode.editor.cn;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CountNicePairsInAnArray1814 {

    public static void main(String[] args) {
        Solution solution = new CountNicePairsInAnArray1814().new Solution();
        System.out.println(solution.countNicePairs(new int[]{13, 10, 35, 24, 76}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int MOD = (int) (1e9 + 7);

        public int countNicePairs(int[] nums) {
            long res = 0;
            // a + c == b + d ===> a - b = d - c 也就意味着 a - rev(a) 相等的就是一对
            Map<Integer, Long> memo = new HashMap<>();

            for (int num : nums) {
                int rev = this.getRev(num);

                memo.put(num - rev, memo.getOrDefault(num - rev, 0L) + 1);
            }

            for (Long value : memo.values()) {
                // value 中任意选两个不在乎顺序
                res = (res + value * (value - 1) / 2) % MOD;
            }

            return (int) res;
        }

        private int getRev(int num) {
            int rev = 0;
            while (num != 0) {
                rev = rev * 10 + num % 10;
                num /= 10;
            }
            return rev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
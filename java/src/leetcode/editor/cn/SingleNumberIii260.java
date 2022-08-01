package leetcode.editor.cn;//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,3,2,5]
//输出：[3,5]
//解释：[5, 3] 也是有效的答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1,0]
//输出：[-1,0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,1]
//输出：[1,0]
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 除两个只出现一次的整数外，nums 中的其他数字都出现两次 
// 
// Related Topics 位运算 数组 👍 636 👎 0


import java.util.Arrays;
import java.util.Objects;

public class SingleNumberIii260 {
    public static void main(String[] args) {
        Solution solution = new SingleNumberIii260().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] singleNumber(int[] nums) {

            if (Objects.isNull(nums) || nums.length == 0) {
                return new int[0];
            }

            if (nums.length == 2) {
                return nums;
            }

            int res = Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);

            // 看从最右边开始哪一位是不同的
            int counter = 0;

            while ((res & 1) == 0) {
                counter++;
                res >>= 1;
            }

            int num1 = 0, num2 = 0;

            for (int num : nums) {
                if (((num >> counter) & 1) == 0) {
                    num1 = num1 ^ num;
                } else {
                    num2 = num2 ^ num;
                }
            }

            return new int[]{num1, num2};
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
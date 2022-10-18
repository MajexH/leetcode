//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
//
// Related Topics 贪心 数学 👍 366 👎 0


package leetcode.editor.cn;

public class MaximumSwap670 {
    public static void main(String[] args) {
        Solution solution = new MaximumSwap670().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            int[] nums = String.valueOf(num)
                    .chars()
                    .map(c -> c - '0')
                    .toArray();

            int i = 0;
            // 找到逆序点
            while (i < nums.length - 1 && nums[i] >= nums[i + 1]) {
                i++;
            }
            // 全部逆序
            if (i == nums.length - 1) {
                return num;
            }

            int j = i + 1, max = j;

            // 向后找到逆序点后最大的
            for (int t = j; t < nums.length; t++) {
                if (nums[t] >= nums[max]) {
                    max = t;
                }
            }

            // 找到最大的了
            if (nums[max] > nums[0]) {
                swap(nums, 0, max);
                return this.toNum(nums);
            }
            // 要找到 跟 i 相等的最前面的数字
            while (i >= 1 && nums[i] == nums[i - 1]) {
                i--;
            }

            swap(nums, max, i);

            return this.toNum(nums);
        }

        private void swap(int[] nums, int i, int j) {
            if (nums[i] == nums[j]) {
                return;
            }
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }

        private int toNum(int[] nums) {
            int res = 0;
            for (int num : nums) {
                res = num + res * 10;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
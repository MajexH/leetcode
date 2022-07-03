//给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。 
//
// 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：21
// 
//
// 示例 2： 
//
// 
//输入：n = 21
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 数学 双指针 字符串 👍 258 👎 0


package src.leetcode.editor.cn;

import java.util.Objects;

public class NextGreaterElementIii556 {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIii556().new Solution();
        System.out.println(solution.nextGreaterElement(21));
        System.out.println(solution.nextGreaterElement(12));
        System.out.println(solution.nextGreaterElement(101));
        System.out.println(solution.nextGreaterElement(1234));
        System.out.println(solution.nextGreaterElement(230241));
        System.out.println(solution.nextGreaterElement(2147483476));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private void swap(char[] chars, int i, int j) {
            if (chars[i] == chars[j]) {
                return;
            }
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }

        private int formatRes(char[] chars) {
            long num = Long.parseLong(new String(chars));
            return (num >= 1 && num <= Integer.MAX_VALUE) ? (int) num : -1;
        }

        private void reverse(char[] nums, int i, int j) {
            while (i <= j) {
                this.swap(nums, i, j);
                i++;
                j--;
            }
        }
        public int nextGreaterElement(int n) {

            char[] chars = Objects.toString(n).toCharArray();

            int index = chars.length - 1;

            // 必须从后向前找 找到逆序点
            while (index >= 1) {
                if (chars[index - 1] >= chars[index]) {
                    index--;
                } else {
                    break;
                }
            }

            // 如果是完全降序
            if (index == 0) {
                // 没有比它更大的
                return -1;
            }

            // 如果是中间的额逆序 从 index 之后找到 第一个恰好大于 index 的数字
            int j = chars.length - 1;
            for (; j >= index && chars[index - 1] >= chars[j]; j--) {
            }

            this.swap(chars, index - 1, j);
            this.reverse(chars, index, chars.length - 1);
            return this.formatRes(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
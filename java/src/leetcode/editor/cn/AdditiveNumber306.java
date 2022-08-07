//累加数 是一个字符串，组成它的数字可以形成累加序列。
//
// 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。 
//
// 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。 
//
// 说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。 
//
// 
//
// 示例 1： 
//
// 
//输入："112358"
//输出：true 
//解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
// 
//
// 示例 2： 
//
// 
//输入："199100199"
//输出：true 
//解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 35 
// num 仅由数字（0 - 9）组成 
// 
//
// 
//
// 进阶：你计划如何处理由过大的整数输入导致的溢出? 
//
// Related Topics 字符串 回溯 👍 373 👎 0


package leetcode.editor.cn;

import java.util.Objects;

public class AdditiveNumber306 {
    public static void main(String[] args) {
        Solution solution = new AdditiveNumber306().new Solution();
        System.out.println(solution.isAdditiveNumber("121474836472147483648"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAdditiveNumber(String num) {

            for (int i = 1; i <= num.length() / 2; i++) {
                for (int j = 1; Math.max(i, j) <= num.length() - i - j; j++) {
                    if (this.isAdditiveNumber(num, i, j)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean isAdditiveNumber(String num, int i, int j) {
            long num1 = this.formatNumber(num.substring(0, i));
            long num2 = this.formatNumber(num.substring(i, i + j));

            if (num1 == -1 || num2 == -1) {
                return false;
            }

            String next = "";
            for (int index = i + j; index < num.length(); index += next.length()) {
                long nextNum = num1 + num2;
                next = Objects.toString(nextNum);
                if (!num.startsWith(next, index)) {
                    return false;
                }
                // 迭代更新
                num1 = num2;
                num2 = nextNum;
            }
            return true;
        }

        private long formatNumber(String num) {
            if (num.length() == 0 || (num.length() > 1 && num.charAt(0) == '0')) {
                return -1;
            }
            return Long.parseLong(num);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
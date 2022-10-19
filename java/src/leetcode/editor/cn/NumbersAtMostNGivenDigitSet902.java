//给定一个按 非递减顺序 排列的数字数组
// digits 。你可以用任意次数 digits[i] 来写的数字。例如，如果
// digits = ['1','3','5']，我们可以写数字，如
// '13', '551', 和 '1351315'。 
//
// 返回 可以生成的小于或等于给定整数 n 的正整数的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = ["1","3","5","7"], n = 100
//输出：20
//解释：
//可写出的 20 个数字是：
//1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
// 
//
// 示例 2： 
//
// 
//输入：digits = ["1","4","9"], n = 1000000000
//输出：29523
//解释：
//我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
//81 个四位数字，243 个五位数字，729 个六位数字，
//2187 个七位数字，6561 个八位数字和 19683 个九位数字。
//总共，可以使用D中的数字写出 29523 个整数。 
//
// 示例 3: 
//
// 
//输入：digits = ["7"], n = 8
//输出：1
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= digits.length <= 9 
// digits[i].length == 1 
// digits[i] 是从 '1' 到 '9' 的数 
// digits 中的所有值都 不同 
// digits 按 非递减顺序 排列 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 数组 数学 字符串 二分查找 动态规划 👍 207 👎 0


package leetcode.editor.cn;

public class NumbersAtMostNGivenDigitSet902 {
    public static void main(String[] args) {
        Solution solution = new NumbersAtMostNGivenDigitSet902().new Solution();
        System.out.println(solution.atMostNGivenDigitSet(new String[]{"1","3","5","7"}, 100));
        System.out.println(solution.atMostNGivenDigitSet(new String[]{"1","4","9"}, 1000000000));
        System.out.println(solution.atMostNGivenDigitSet(new String[]{"7"}, 8));
        System.out.println(solution.atMostNGivenDigitSet(new String[]{"5", "6"}, 19));
        System.out.println(solution.atMostNGivenDigitSet(new String[]{"3", "4", "8"}, 4));
        System.out.println(solution.atMostNGivenDigitSet(new String[]{"5", "7", "8"}, 59));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int atMostNGivenDigitSet(String[] digits, int n) {
            // 获取数字 n 的长度
            char[] chars = String.valueOf(n).toCharArray();

            int length = chars.length;

            // 从 1 -> length - 1 都是组合数
            int res = 0;
            for (int i = 1; i <= length - 1; i++) {
                res += Math.pow(digits.length, i);
            }

            // 从最小值开始 一步一步 推到 最大值
            // 从后向前遍历数字
            return this.recursion(0, digits, chars) + res;
        }

        private int recursion(int j, String[] digits, char[] chars) {
            if (j == chars.length) {
                return 1;
            }
            int res = 0;
            for (int i = digits.length - 1; i >= 0; i--) {
                // 如果大于的话 说明不可能
                if (digits[i].charAt(0) > chars[j]) {
                    continue;
                }
                // 小于的话 说明下面的可以随意组合
                if (digits[i].charAt(0) < chars[j]) {
                    // 看看 chars 还剩下几位 说明这几位是个组合
                    res += Math.pow(digits.length, chars.length - j - 1D);
                    continue;
                }

                // 如果等于的话 就要遍历下一位
                res += this.recursion(j + 1, digits, chars);

            }
            return res;
        }

        // 直接递归复杂度太高了
        private int recursion(String[] digits, StringBuilder builder, int length, String n) {
            if (builder.length() >= length) {
                if (builder.toString().compareTo(n) <= 0) {
                    return 1;
                }
                return 0;
            }
            int res = 0;
            for (String digit : digits) {
                builder.append(digit);
                res += this.recursion(digits, builder, length, n);
                builder.deleteCharAt(builder.length() - 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
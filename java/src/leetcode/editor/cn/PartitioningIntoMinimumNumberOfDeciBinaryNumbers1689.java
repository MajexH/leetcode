//如果一个十进制数字不含任何前导零，且每一位上的数字不是 0 就是 1 ，那么该数字就是一个 十-二进制数 。例如，101 和 1100 都是 十-二进制数，
//而 112 和 3001 不是。 
//
// 给你一个表示十进制整数的字符串 n ，返回和为 n 的 十-二进制数 的最少数目。 
//
// 
//
// 示例 1： 
//
// 输入：n = "32"
//输出：3
//解释：10 + 11 + 11 = 32
// 
//
// 示例 2： 
//
// 输入：n = "82734"
//输出：8
// 
//
// 示例 3： 
//
// 输入：n = "27346209830709182346"
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n.length <= 10⁵ 
// n 仅由数字组成 
// n 不含任何前导零并总是表示正整数 
// 
//
// Related Topics 贪心 字符串 👍 43 👎 0


package leetcode.editor.cn;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers1689 {
    public static void main(String[] args) {
        Solution solution = new PartitioningIntoMinimumNumberOfDeciBinaryNumbers1689().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPartitions(String n) {
            // 最大的一位数是多少就有多少个
            int max = 0;
            for (char c : n.toCharArray()) {
                max = Math.max(max, c - '0');
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
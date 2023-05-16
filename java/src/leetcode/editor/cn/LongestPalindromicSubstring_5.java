//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6488 👎 0


package src.leetcode.editor.cn;

public class LongestPalindromicSubstring_5 {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring_5().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {

            String res = "";

            boolean[][] dp = new boolean[s.length()][s.length()];

            for (int i = s.length() - 1; i >= 0; i--) {
                dp[i][i] = true;
                for (int j = i; j < s.length(); j++) {
                    dp[i][j] = (i == j || j == i + 1 || dp[i + 1][j - 1]) && (s.charAt(i) == s.charAt(j));

                    if (dp[i][j] && j - i + 1 >= res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
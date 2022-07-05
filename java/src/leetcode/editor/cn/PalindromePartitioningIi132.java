package leetcode.editor.cn;//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
// Related Topics 字符串 动态规划 👍 590 👎 0


import java.util.Arrays;
import java.util.Objects;

public class PalindromePartitioningIi132 {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioningIi132().new Solution();
        System.out.println(solution.minCut("aab"));
        System.out.println(solution.minCut("a"));
        System.out.println(solution.minCut("ab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {

            if (Objects.isNull(s) || s.length() == 0) {
                return 0;
            }

            // isPalindrome[i][j] 表示从 i - j
            boolean[][] isPalindrome = new boolean[s.length()][s.length()];

            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j >= 0; j--) {
                    isPalindrome[j][i] = s.charAt(i) == s.charAt(j) && (i == j || i == j + 1 || isPalindrome[j + 1][i - 1]);
                }
            }

            int[] minCuts = new int[s.length()];
            Arrays.fill(minCuts, Integer.MAX_VALUE);

            for (int i = 0; i < s.length(); i++) {
                // 如果 0 - i 是一个回文数 那么 i 的最小切割就是自身 不用切割
                if (isPalindrome[0][i]) {
                    minCuts[i] = 0;
                    continue;
                }

                // 如果不是回文数 需要遍历下面的回文串
                for (int j = i; j >= 0; j--) {
                    // 如果这个时候 j-i 是回文串 那么只需要在 minCuts[j] 的基础上划分一次即可
                    if (isPalindrome[j][i]) {
                        minCuts[i] = Math.min(minCuts[i], minCuts[j - 1] + 1);
                    }
                }
            }
            return minCuts[s.length() - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
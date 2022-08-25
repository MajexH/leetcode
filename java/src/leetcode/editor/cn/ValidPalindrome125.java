//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 564 👎 0


package leetcode.editor.cn;

public class ValidPalindrome125 {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome125().new Solution();
        System.out.println(solution.isPalindrome("0P"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {

            int i = 0, j = s.length() - 1;

            while (i < j) {
                if (!this.isAlphabetOrNumber(s.charAt(i))) {
                    i++;
                    continue;
                }
                if (!this.isAlphabetOrNumber(s.charAt(j))) {
                    j--;
                    continue;
                }

                if (s.charAt(i) == s.charAt(j) || (Character.isAlphabetic(s.charAt(i)) && Character.isAlphabetic(s.charAt(j)) && Math.abs(s.charAt(i) - s.charAt(j)) == 'a' - 'A')) {
                    i++;
                    j--;
                    continue;
                }

                return false;
            }

            return true;
        }

        private boolean isAlphabetOrNumber(char c) {
            return (c  >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
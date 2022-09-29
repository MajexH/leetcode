//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。 
//
// 示例1: 
//
//  输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
// 
//
// 示例2: 
//
//  输入：s1 = "aa", s2 = "aba"
// 输出：False
// 
//
// 
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 100000]范围内。 
// 
//
// 说明: 
//
// 
// 你能只调用一次检查子串的方法吗？ 
// 
//
// Related Topics 字符串 字符串匹配 👍 153 👎 0


package leetcode.editor.cn;

import java.util.Objects;

public class StringRotationLcci_01_09 {
    public static void main(String[] args) {
        Solution solution = new StringRotationLcci_01_09().new Solution();
        System.out.println(solution.isFlipedString("", ""));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // s2 是否为 s1 的旋转字符串
        // 暴力解法
        public boolean isFlipedString(String s1, String s2) {

            if ((s1 == null || s1.length() == 0) && (s2 == null || s2.length() == 0)) {
                return true;
            }

            if (!Objects.equals(s1.length(), s2.length())) {
                return false;
            }

            for (int i = 0; i < s1.length(); i++) {

                // 如果最后一位匹配了 就可以开始遍历了
                if (s1.charAt(i) == s2.charAt(s2.length() - 1)) {
                    if (check(s1, s2, i)) {
                        return true;
                    }
                }
            }

            return false;
        }

        public boolean check(String s1, String s2, int s1Index) {
            int i = s1Index, j = s2.length() - 1;
            // 从后向前遍历
            while (i >= 0 && j >= 0) {
                if (s1.charAt(i) != s2.charAt(j)) {
                    return false;
                }
                i--;
                j--;
            }

            // 从前向后遍历
            i = s1Index + 1;
            j = 0;
            while (j < s2.length() && i < s1.length()) {
                if (s1.charAt(i) != s2.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
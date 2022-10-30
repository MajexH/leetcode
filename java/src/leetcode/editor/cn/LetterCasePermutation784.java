//<p>给定一个字符串&nbsp;<code>s</code>&nbsp;，通过将字符串&nbsp;<code>s</code>&nbsp;中的每个字母转变大小写，我们可以获得一个新的字符串。</p>
//
//<p>返回 <em>所有可能得到的字符串集合</em> 。以 <strong>任意顺序</strong> 返回输出。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "a1b2"
//<strong>输出：</strong>["a1b2", "a1B2", "A1b2", "A1B2"]
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> s = "3z4"
//<strong>输出:</strong> ["3z4","3Z4"]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= s.length &lt;= 12</code></li> 
// <li><code>s</code>&nbsp;由小写英文字母、大写英文字母和数字组成</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>位运算</li><li>字符串</li><li>回溯</li></div></div><br><div><li>👍 446</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation784 {
    public static void main(String[] args) {
        Solution solution = new LetterCasePermutation784().new Solution();
        System.out.println(solution.letterCasePermutation("a1b1"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCasePermutation(String s) {
            List<String> res = new ArrayList<>();

            this.recursion(0, s, res, new StringBuilder());

            return res;
        }

        private void recursion(int index, String s, List<String> res, StringBuilder builder) {
            if (index == s.length()) {
                res.add(builder.toString());
                return;
            }

            if (!Character.isAlphabetic(s.charAt(index))) {
                builder.append(s.charAt(index));
                this.recursion(index + 1, s, res, builder);
                builder.deleteCharAt(builder.length() - 1);
                return;
            }

            for (char c : this.getChars(s.charAt(index))) {
                builder.append(c);
                this.recursion(index + 1, s, res, builder);
                builder.deleteCharAt(builder.length() - 1);
            }
        }

        private char[] getChars(char alphabet) {
            if (alphabet >= 'a' && alphabet <= 'z') {
                return new char[]{alphabet, (char) (alphabet - 'a' + 'A')};
            }
            return new char[]{alphabet, (char) (alphabet - 'A' + 'a')};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
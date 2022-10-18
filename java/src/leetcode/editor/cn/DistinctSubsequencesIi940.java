//<p>给定一个字符串 <code>s</code>，计算 <code>s</code> 的 <strong>不同非空子序列</strong> 的个数。因为结果可能很大，所以返回答案需要对<strong> </strong><strong><code>10^9 + 7</code> 取余</strong> 。</p>
//
//<p>字符串的 <strong>子序列</strong> 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。</p>
//
//<ul> 
// <li>例如，<code>"ace"</code> 是 <code>"<em><strong>a</strong></em>b<em><strong>c</strong></em>d<em><strong>e</strong></em>"</code> 的一个子序列，但 <code>"aec"</code> 不是。</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "abc"
//<strong>输出：</strong>7
//<strong>解释：</strong>7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "aba"
//<strong>输出：</strong>6
//<strong>解释：</strong>6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "aaa"
//<strong>输出：</strong>3
//<strong>解释：</strong>3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= s.length &lt;= 2000</code></li> 
// <li><code>s</code> 仅由小写英文字母组成</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 272</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.Arrays;

public class DistinctSubsequencesIi940 {
    public static void main(String[] args) {
        Solution solution = new DistinctSubsequencesIi940().new Solution();
        // 836817663
        System.out.println(solution.distinctSubseqII("pcrdhwdxmqdznbenhwjsenjhvulyve"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int MOD = 1000000007;
        // 如何去重
        // 当前 = 之前的 + 新增的 - 重复的
        // 重复的实际上是上个相同字母的新增数
        public int distinctSubseqII(String s) {
            // 只要开始到当前这个位置 前面有与最后一个位置相同的字符 那么就是不可以再生成的了
            int[] preCounter = new int[26];

            // "" 字符串算一个
            int cur = 1;

            for (int i = 0; i < s.length(); i++) {
                // 新增的等于上轮的数量
                int added = cur;
                cur = ((cur + added) % MOD - preCounter[s.charAt(i) - 'a'] % MOD + MOD) % MOD;
                preCounter[s.charAt(i) - 'a'] = added;
            }

            // 减去 "" 字符串
            return cur - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
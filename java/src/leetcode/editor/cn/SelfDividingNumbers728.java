//<p><strong>自除数</strong><em>&nbsp;</em>是指可以被它包含的每一位数整除的数。</p>
//
//<ul> 
// <li>例如，<code>128</code> 是一个 <strong>自除数</strong> ，因为&nbsp;<code>128 % 1 == 0</code>，<code>128 % 2 == 0</code>，<code>128 % 8 == 0</code>。</li> 
//</ul>
//
//<p><strong>自除数</strong> 不允许包含 0 。</p>
//
//<p>给定两个整数&nbsp;<code>left</code>&nbsp;和&nbsp;<code>right</code> ，返回一个列表，<em>列表的元素是范围&nbsp;<code>[left, right]</code>&nbsp;内所有的 <strong>自除数</strong></em> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>left = 1, right = 22
//<strong>输出：</strong>[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<b>输入：</b>left = 47, right = 85
//<b>输出：</b>[48,55,66,77]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= left &lt;= right &lt;= 10<sup>4</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数学</li></div></div><br><div><li>👍 247</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers728 {
    public static void main(String[] args) {
        Solution solution = new SelfDividingNumbers728().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> res = new ArrayList<>();

            while (left <= right) {
                if (this.isSelfDividingNumbers(left)) {
                    res.add(left);
                }
                left++;
            }

            return res;
        }

        public boolean isSelfDividingNumbers(int num) {
            int temp = num;

            while (temp > 0) {
                int digit = temp % 10;

                if (digit == 0 || num % digit != 0) {
                    return false;
                }

                temp /= 10;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
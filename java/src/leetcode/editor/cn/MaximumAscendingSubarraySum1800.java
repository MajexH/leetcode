//<p>给你一个正整数组成的数组 <code>nums</code> ，返回 <code>nums</code> 中一个 <strong>升序 </strong>子数组的最大可能元素和。</p>
//
//<p>子数组是数组中的一个连续数字序列。</p>
//
//<p>已知子数组 <code>[nums<sub>l</sub>, nums<sub>l+1</sub>, ..., nums<sub>r-1</sub>, nums<sub>r</sub>]</code> ，若对所有 <code>i</code>（<code>l &lt;= i &lt; r</code>），<code>nums<sub>i </sub> &lt; nums<sub>i+1</sub></code> 都成立，则称这一子数组为 <strong>升序</strong> 子数组。注意，大小为 <code>1</code> 的子数组也视作 <strong>升序</strong> 子数组。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [10,20,30,5,10,50]
//<strong>输出：</strong>65
//<strong>解释：</strong>[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [10,20,30,40,50]
//<strong>输出：</strong>150
//<strong>解释：</strong>[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。 
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [12,17,15,13,10,11,12]
//<strong>输出：</strong>33
//<strong>解释：</strong>[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。 
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [100,10,1]
//<strong>输出：</strong>100
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 100</code></li> 
// <li><code>1 &lt;= nums[i] &lt;= 100</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li></div></div><br><div><li>👍 86</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.Objects;

public class MaximumAscendingSubarraySum1800 {
    public static void main(String[] args) {
        Solution solution = new MaximumAscendingSubarraySum1800().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAscendingSum(int[] nums) {

            if (Objects.isNull(nums) || nums.length == 0) {
                return 0;
            }

            int res = nums[0];
            int cur = nums[0];

            for (int i = 1; i < nums.length; i++) {
                // 逆序
                if (nums[i] <= nums[i - 1]) {
                    res = Math.max(res, cur);
                    cur = nums[i];
                    continue;
                }
                cur += nums[i];
            }

            res = Math.max(res, cur);

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
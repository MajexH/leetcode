//<p>给定一个长度为 <code>n</code> 的整数数组 <code>arr</code> ，它表示在 <code>[0, n - 1]</code> 范围内的整数的排列。</p>
//
//<p>我们将 <code>arr</code> 分割成若干 <strong>块</strong> (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。</p>
//
//<p>返回数组能分成的最多块数量。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入:</strong> arr = [4,3,2,1,0]
//<strong>输出:</strong> 1
//<strong>解释:</strong>
//将数组分成2块或者更多块，都无法得到所需的结果。
//例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> arr = [1,0,2,3,4]
//<strong>输出:</strong> 4
//<strong>解释:</strong>
//我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
//然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul> 
// <li><code>n == arr.length</code></li> 
// <li><code>1 &lt;= n &lt;= 10</code></li> 
// <li><code>0 &lt;= arr[i] &lt; n</code></li> 
// <li><code>arr</code>&nbsp;中每个元素都 <strong>不同</strong></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>栈</li><li>贪心</li><li>数组</li><li>排序</li><li>单调栈</li></div></div><br><div><li>👍 354</li><li>👎 0</li></div>

package leetcode.editor.cn;

public class MaxChunksToMakeSorted769 {
    public static void main(String[] args) {
        Solution solution = new MaxChunksToMakeSorted769().new Solution();
        System.out.println(solution.maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println(solution.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
        System.out.println(solution.maxChunksToSorted(new int[]{1, 2, 0, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 前一个分区的最大值小于后一个分区的最小值
        public int maxChunksToSorted(int[] arr) {
            int res = 0;

            int max = Integer.MIN_VALUE;

            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                if (num > max && i > max) {
                    res++;
                }
                max = Math.max(max, num);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
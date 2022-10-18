//<p>给你一个整数数组 <code>arr</code> ，数组中的每个整数 <strong>互不相同</strong> 。另有一个由整数数组构成的数组 <code>pieces</code>，其中的整数也 <strong>互不相同</strong> 。请你以 <strong>任意顺序</strong> 连接 <code>pieces</code> 中的数组以形成 <code>arr</code> 。但是，<strong>不允许</strong> 对每个数组 <code>pieces[i]</code> 中的整数重新排序。</p>
//
//<p>如果可以连接<em> </em><code>pieces</code> 中的数组形成 <code>arr</code> ，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>arr = [15,88], pieces = [[88],[15]]
//<strong>输出：</strong>true
//<strong>解释：</strong>依次连接 <span><code>[15]</code></span> 和 <span><code>[88]</code></span>
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>arr = [49,18,16], pieces = [[16,18,49]]
//<strong>输出：</strong>false
//<strong>解释：</strong>即便数字相符，也不能重新排列 pieces[0]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
//<strong>输出：</strong>true
//<strong>解释：</strong>依次连接 <span><code>[91]</code></span>、<span><code>[4,64]</code></span> 和 <span><code>[78]</code></span></pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= pieces.length &lt;= arr.length &lt;= 100</code></li> 
// <li><code>sum(pieces[i].length) == arr.length</code></li> 
// <li><code>1 &lt;= pieces[i].length &lt;= arr.length</code></li> 
// <li><code>1 &lt;= arr[i], pieces[i][j] &lt;= 100</code></li> 
// <li><code>arr</code> 中的整数 <strong>互不相同</strong></li> 
// <li><code>pieces</code> 中的整数 <strong>互不相同</strong>（也就是说，如果将 <code>pieces</code> 扁平化成一维数组，数组中的所有整数互不相同）</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li></div></div><br><div><li>👍 121</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckArrayFormationThroughConcatenation1640 {
    public static void main(String[] args) {
        Solution solution = new CheckArrayFormationThroughConcatenation1640().new Solution();
        System.out.println(solution.canFormArray(new int[]{15,88}, new int[][]{{88},{15}}));
        System.out.println(solution.canFormArray(new int[]{91,4,64,78}, new int[][]{{78},{4,64},{91}}));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            Map<Integer, List<int[]>> map = new HashMap<>();

            for (int[] piece : pieces) {
                map.computeIfAbsent(piece[0], k -> new ArrayList<>()).add(piece);
            }

            int i = 0;
            while (i < arr.length) {
                if (!map.containsKey(arr[i])) {
                    return false;
                }
                boolean flag = false;
                for (int[] piece : map.get(arr[i])) {
                    // 一起移动
                    int j = i, m = 0;
                    for (; m < piece.length && j < arr.length; j++, m++) {
                        if (arr[j] != piece[m]) {
                            break;
                        }
                    }
                    // 遍历完
                    if (j == i + piece.length) {
                        i = j;
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
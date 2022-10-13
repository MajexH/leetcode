//<p>给定两个大小相等的数组&nbsp;<code>nums1</code>&nbsp;和&nbsp;<code>nums2</code>，<code>nums1</code>&nbsp;相对于 <code>nums2</code> 的<em>优势</em>可以用满足&nbsp;<code>nums1[i] &gt; nums2[i]</code>&nbsp;的索引 <code>i</code>&nbsp;的数目来描述。</p>
//
//<p>返回 <font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace" size="1"><span style="background-color: rgb(249, 242, 244);">nums1</span></font>&nbsp;的<strong>任意</strong>排列，使其相对于 <code>nums2</code>&nbsp;的优势最大化。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//<strong>输出：</strong>[2,11,7,15]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//<strong>输出：</strong>[24,32,8,12]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums1.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>nums2.length == nums1.length</code></li> 
// <li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>9</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 303</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class AdvantageShuffle870 {
    public static void main(String[] args) {
        Solution solution = new AdvantageShuffle870().new Solution();
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] advantageCount(int[] nums1, int[] nums2) {
            List<Integer> sortedNums = Arrays.stream(nums1)
                    .boxed()
                    .sorted()
                    .collect(Collectors.toList());

            Integer[] res = new Integer[nums1.length];

            for (int i = 0; i < nums2.length; i++) {

                Integer index = this.binarySearch(sortedNums, nums2[i]);
                if (Objects.isNull(index)) {
                    continue;
                }

                res[i] = sortedNums.remove(index.intValue());
            }

            for (int i = 0; i < nums1.length; i++) {
                if (Objects.nonNull(res[i])) {
                    continue;
                }

                res[i] = sortedNums.remove(0);
            }

            return Arrays.stream(res).mapToInt(Integer::intValue).toArray();
        }

        private Integer binarySearch(List<Integer> list, int target) {
            int i = 0, j = list.size() - 1;

            while (i < j) {
                int mid = i + ((j - i) >> 1);

                if (list.get(mid) <= target) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }

            if (list.get(j) > target) {
                return j;
            }

            return null;
        }

        public int[] advantageCountWithTreeMap(int[] nums1, int[] nums2) {

            TreeMap<Integer, Integer> memo = new TreeMap<>();

            for (int num : nums1) {
                memo.put(num, memo.getOrDefault(num, 0) + 1);
            }

            Integer[] res = new Integer[nums1.length];

            for (int i = 0; i < nums2.length; i++) {
                Integer higher = memo.higherKey(nums2[i]);
                if (Objects.isNull(higher)) {
                    continue;
                }
                res[i] = higher;

                int counter = memo.get(higher) - 1;
                if (counter == 0) {
                    memo.remove(higher);
                } else {
                    memo.put(higher, counter);
                }
            }

            for (int i = 0; i < nums1.length; i++) {
                if (Objects.nonNull(res[i])) {
                    continue;
                }

                Map.Entry<Integer, Integer> entry = memo.pollFirstEntry();
                res[i] = entry.getKey();

                int counter = entry.getValue() - 1;
                if (counter == 0) {
                    memo.remove(entry.getKey());
                } else {
                    memo.put(entry.getKey(), counter);
                }

            }

            return Arrays.stream(res).mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
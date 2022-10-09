//<p>给定一个整数数组&nbsp;&nbsp;<code>nums</code> 和一个正整数 <code>k</code>，找出是否有可能把这个数组分成 <code>k</code> 个非空子集，其总和都相等。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong> nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//<strong>输出：</strong> True
//<strong>说明：</strong> 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = [1,2,3,4], k = 3
//<strong>输出:</strong> false</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= k &lt;= len(nums) &lt;= 16</code></li> 
// <li><code>0 &lt; nums[i] &lt; 10000</code></li> 
// <li>每个元素的频率在 <code>[1,4]</code> 范围内</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>位运算</li><li>记忆化搜索</li><li>数组</li><li>动态规划</li><li>回溯</li><li>状态压缩</li></div></div><br><div><li>👍 822</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionToKEqualSumSubsets698 {

    public static void main(String[] args) {
        Solution solution = new PartitionToKEqualSumSubsets698().new Solution();

        System.out.println(solution.canPartitionKSubsets(new int[]{4,3,2,3,5,2,1}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = Arrays.stream(nums).sum();
            if (k == 1) return true;
            if (sum % k != 0) {
                return false;
            }

            Arrays.sort(nums);

            int arraySum = sum / k;
            int[] bucket = new int[k];
            Arrays.fill(bucket, arraySum);

            return this.recursion(bucket, nums, nums.length - 1, k);
        }

        public boolean recursion(int[] bucket, int[] nums, int index, int k) {
            if (index < 0) {
                return true;
            }

            // 遍历桶
            for (int i = 0; i < k; i++) {
                // 如果桶能够放下
                // 如果减去之后还能够放下 最小的数 那么说明还可以继续放 否则不可以放了 就剪枝了
                if (bucket[i] == nums[index] || bucket[i] - nums[index] >= nums[0]) {
                    bucket[i] -= nums[index];
                    if (this.recursion(bucket, nums, index - 1, k)) {
                        return true;
                    }
                    bucket[i] += nums[index];
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
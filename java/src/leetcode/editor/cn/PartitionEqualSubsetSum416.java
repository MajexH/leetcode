//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1434 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Objects;

public class PartitionEqualSubsetSum416 {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum416().new Solution();
        System.out.println(solution.canPartition(new int[]{1, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {

            if (Objects.isNull(nums) || nums.length == 0) {
                return true;
            }

            int sum = Arrays.stream(nums).reduce(0, Integer::sum);

            // 奇数 不可能
            if ((sum & 1) == 1) {
                return false;
            }
            // 尝试分类
            boolean[][] dp = new boolean[nums.length + 1][sum / 2 + 1];
            dp[0][0] = true;
            for (int i = 1; i <= nums.length; i++) {
                for (int j = sum / 2; j >= 0; j--) {
                    if (j >= nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[nums.length][sum / 2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
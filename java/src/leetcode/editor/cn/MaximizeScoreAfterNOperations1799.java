//给你 nums ，它是一个大小为 2 * n 的正整数数组。你必须对这个数组执行 n 次操作。 
//
// 在第 i 次操作时（操作编号从 1 开始），你需要： 
//
// 
// 选择两个元素 x 和 y 。 
// 获得分数 i * gcd(x, y) 。 
// 将 x 和 y 从 nums 中删除。 
// 
//
// 请你返回 n 次操作后你能获得的分数和最大为多少。 
//
// 函数 gcd(x, y) 是 x 和 y 的最大公约数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2]
//输出：1
//解释：最优操作是：
//(1 * gcd(1, 2)) = 1
// 
//
// 示例 2： 
//
// 输入：nums = [3,4,6,8]
//输出：11
//解释：最优操作是：
//(1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,5,6]
//输出：14
//解释：最优操作是：
//(1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 7 
// nums.length == 2 * n 
// 1 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 位运算 数组 数学 动态规划 回溯 状态压缩 数论 👍 58 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MaximizeScoreAfterNOperations1799 {
    public static void main(String[] args) {
        Solution solution = new MaximizeScoreAfterNOperations1799().new Solution();
        System.out.println(solution.maxScore(new int[]{1, 2}));
        System.out.println(solution.maxScore(new int[]{3, 4, 6, 8}));
        System.out.println(solution.maxScore(new int[]{1, 2, 3, 4, 5, 6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxScore(int[] nums) {
            // 状态变量
            // 如果 nums[i] 被选择过 那么 status ^ (1 << i) 位
            // 这样才能把 boolean 的状态压缩 然后剪枝
            int status = 0;
            // status 对应的 score 是多少
            Map<Integer, Integer> memo = new HashMap<>();
            // 每次选 最小的两个数
            this.dfs(nums, status, memo, 0, 1);
            // 所有的数字全选即为最后的状态
            return memo.get((1 << nums.length) - 1);
        }

        private void dfs(int[] nums, int status, Map<Integer, Integer> memo, int score, int cnt) {

            // 剪枝
            if (memo.containsKey(status) && memo.get(status) >= score) {
                return;
            }
            memo.put(status, score);
            for (int i = 0; i < nums.length; i++) {
                // 已经取过
                if (((status >> i) & 1) == 1) {
                    continue;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    // 已经取过
                    if (((status >> j) & 1) == 1) {
                        continue;
                    }
                    int gcd = this.gcd(Math.max(nums[i], nums[j]), Math.min(nums[i], nums[j]));
                    this.dfs(nums, status ^ (1 << i) ^ (1 << j), memo, score + cnt * gcd, cnt + 1);
                }
            }

        }

        private int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return this.gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
//
// 由于答案可能很大，因此 返回答案模 10^9 + 7 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,2,4]
//输出：17
//解释：
//子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
//最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。 
//
// 示例 2： 
//
// 
//输入：arr = [11,81,94,43,3]
//输出：444
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 3 * 10⁴ 
// 1 <= arr[i] <= 3 * 10⁴ 
// 
//
// 
//
// Related Topics 栈 数组 动态规划 单调栈 👍 548 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SumOfSubarrayMinimums907 {
    public static void main(String[] args) {
        Solution solution = new SumOfSubarrayMinimums907().new Solution();
        System.out.println(solution.sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static Integer MOD = (int) 1e9 + 7;

        public int sumSubarrayMins(int[] arr) {
            long res = 0L;

            // dp[i] 表示当前结尾的时候 前面有多少个中间结果
            int[] dp = new int[arr.length];

            Deque<Integer> stack = new LinkedList<>();

            for (int i = 0; i < arr.length; i++) {
                while (!stack.isEmpty() && arr[stack.peekLast()] > arr[i]) {
                    stack.removeLast();
                }

                int k = stack.isEmpty() ? (i + 1) : i - stack.peekLast();
                dp[i] = k * arr[i] + (stack.isEmpty() ? 0 : dp[i - k]);
                res = (res + dp[i]) % MOD;
                stack.addLast(i);
            }

            return (int) res;
        }

        /**
         * o(n^2) 的解法也是超时的 那么只有 o(n) 的解法了
         */
        public int sumSubarrayMinsOn2(int[] arr) {
            int[] stacks = new int[arr.length];

            Arrays.fill(stacks, Integer.MAX_VALUE);
            int res = 0;

            for (int end = 0; end < arr.length; end++) {
                for (int start = 0; start <= end; start++) {
                    // 如果比末尾小 那么就不管了
                    if (stacks[start] > arr[end]) {
                        stacks[start] = arr[end];
                    }
                    res = (res + stacks[start]) % MOD;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
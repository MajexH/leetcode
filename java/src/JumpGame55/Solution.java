package JumpGame55;

import java.util.Arrays;

public class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        boolean[] dp = new boolean[length];
        // 最后一个位置肯定是可以过去的
        dp[length - 1] = true;
        for (int i = length - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                // 状态转移方程 现在这个状态能否过去 肯定依赖于上个状态能否过去
                if (dp[Math.min(i + j, length - 1)]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2, 5, 0, 0}));
    }
}

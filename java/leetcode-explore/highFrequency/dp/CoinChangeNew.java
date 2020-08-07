package highFrequency.dp;

import java.util.Arrays;

public class CoinChangeNew {

    // 凑成总金额需要的 最小的硬币的个数
    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示总金额为 i 需要的最少的硬币的个数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 兜底
        dp[0] = 0;
        // 这是一个完全背包
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i  - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

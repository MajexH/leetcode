package highFrequency.dp;

import java.util.Arrays;

public class CoinChange_New {

    // 背包问题
    public int coinChange(int[] coins, int amount) {
        if (amount == 0 || coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        Arrays.sort(coins);
        for (int i = 0; i <= amount; i++) {
            for (int j = coins.length - 1; j >= 0; j--) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange_New().coinChange(new int[]{1,2,5}, 11));
        System.out.println(new CoinChange_New().coinChange(new int[]{2}, 3));
        System.out.println(new CoinChange_New().coinChange(new int[]{1}, 0));
        System.out.println(new CoinChange_New().coinChange(new int[]{1}, 1));
        System.out.println(new CoinChange_New().coinChange(new int[]{1}, 2));
    }
}

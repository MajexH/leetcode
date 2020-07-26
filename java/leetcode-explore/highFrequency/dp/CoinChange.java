package highFrequency.dp;

import java.util.Arrays;

public class CoinChange {

    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回 -1。
     *
     * 实际上是一个完全背包
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示总金额为 i，最少可以凑成的硬币数为多少
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 能够达到 0 的是不存在的
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // 如果总金额不够coin是不行的 而且如果 上一个状态是不可达的 也不行
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{2,1,5}, 11));
    }
}

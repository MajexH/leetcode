import java.util.Arrays;

public class Change_518 {

    // 如果 coins 有无线个 问有几种方案可以组成成 amount
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Change_518().change(5, new int[]{1, 2, 5}));
    }

}

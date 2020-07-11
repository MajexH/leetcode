import java.util.Arrays;

public class coinChange_322 {

    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int minLength = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    // 防止溢出 说明不可能达到
                    if (dp[i - coins[j]] == Integer.MAX_VALUE) {
                        continue;
                    }
                    minLength = Math.min(minLength, dp[i - coins[j]] + 1);
                }
            }
            dp[i] = minLength;
        }
//        System.out.println(Arrays.toString(dp));
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public int recursion(int start, int target, int[] coins, int count) {
        if (target < 0) return Integer.MAX_VALUE;
        if (target == 0) {
            return count;
        }
        int res = Integer.MAX_VALUE;
        for (int i = start; i < coins.length; i++) {
            res = Math.min(res, recursion(i, target - coins[i], coins, count + 1));
        }
        return res;
    }


    public int coinChange(int[] coins, int amount) {
        int res = recursion(0, amount, coins, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(new coinChange_322().coinChange(new int[]{1,2,5}, 11));
        System.out.println(new coinChange_322().coinChange1(new int[]{2}, 3));
    }
}

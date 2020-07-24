package chapter2.algorithm;

public class FrogJumStairs_10 {

    public int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        // dp[i] 表示 i 级台阶需要跳的次数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}

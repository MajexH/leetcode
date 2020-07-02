package dp;

public class ClimbStairs {

    // 一次只能爬 1 个或者两个台阶 有多少种爬法
    public int climbStairs(int n) {
        // dp[i] 表示梯子为 i 时有几种方法可以上楼
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

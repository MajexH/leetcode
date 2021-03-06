package tencent.dp;

import java.util.Arrays;

public class NumSquares {

    // 问能够组成 n 的完全平方数的个数为多少
    public int numSquares(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 初始化
        dp[0] = 0;
        // 初始化完全平方数数量为 1
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            // 切分点 实际上只需要知道分隔点左右两次加起来的最小值
            for (int j = i - 1; j >= i / 2; j--) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(12));
        System.out.println(new NumSquares().numSquares(13));
    }
}

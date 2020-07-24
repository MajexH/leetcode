package chapter2.dp;

import java.util.Arrays;

public class CutRopes {

    /**
     * 一个绳子的长度是 n
     * 将其简称 k[0] k[1] …… k[m] 长度的小绳子
     * 问这些小绳子的长度可能的最大乘积是多少
     * @param n 绳子的长度
     * @return 剪完绳子的最大值
     */
    public int cutRopes(int n) {
        // dp[i] 表示长度为 i 的绳子 能够形成的最大乘积
        int[] dp = new int[n + 1];
        // 长度为 1  的只能剪成1
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // j 代表切割点
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * Math.max(dp[i - j] ,i - j));
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new CutRopes().cutRopes(8));
    }
}

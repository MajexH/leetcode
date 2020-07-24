package chapter2.dp;

public class CutRopesNew {

    /**
     * 给定一根长度为 n 的绳子 问将其剪断成几段能够形成的每段长度的最大乘积是多少
     * 例如 n = 8 最大长度是 2 * 3 * 3 = 18
     * @param n
     * @return
     */
    public int cutRopes(int n) {
        // dp[i] 表示长度为 i 的绳子能够剪成的每段长度的最大乘积
        int[] dp = new int[n + 1];
        // 兜底
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new CutRopesNew().cutRopes(8));
    }
}

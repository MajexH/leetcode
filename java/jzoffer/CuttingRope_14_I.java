public class CuttingRope_14_I {

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * (i - j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new CuttingRope_14_I().cuttingRope(2));
        System.out.println(new CuttingRope_14_I().cuttingRope(10));
    }
}

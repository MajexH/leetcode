public class PartitionArrayforMaximumSumNew_1043 {

    public int maxSumAfterPartitioning(int[] A, int K) {
        // dp[i] 表示以 A[i] 结尾的数儿能形成的最大值
        int[] dp = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int max = 0;
            for (int j = i; j >= Math.max(0, i - K + 1); j--) {
                max = Math.max(max, A[j]);
                dp[i] = Math.max(dp[i], (j - 1 < 0 ? 0 : dp[j - 1]) + max * (i - j + 1));
            }
        }
        return dp[A.length - 1];
    }
}

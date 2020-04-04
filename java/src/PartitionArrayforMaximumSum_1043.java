import java.util.Arrays;

public class PartitionArrayforMaximumSum_1043 {

    public int maxSumAfterPartitioning(int[] A, int K) {
        // dp[i] 表示当前的前面的partition的最大值
        int[] dp = new int[A.length];
        Arrays.fill(dp, 0);
        for (int i = 0; i < A.length; i++) {
            int curMax = Integer.MIN_VALUE;
            for (int j = i; j >= Math.max(0, i - K + 1); j--) {
                curMax = Math.max(curMax, A[j]);
                // 这个地方就是去用A数组的最后一个 去替换它前面 K 个来决定大小
                // 其中dp[j - 1] 就是去除当前遍历的最后一个的前面的最优解
                dp[i] = Math.max(dp[i], (j - 1 < 0 ? 0 : dp[j - 1]) + curMax * (i - j + 1));
            }
        }
        return dp[A.length - 1];
    }
}

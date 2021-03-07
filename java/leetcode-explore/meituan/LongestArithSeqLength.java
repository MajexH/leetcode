package meituan;

import java.util.Arrays;

public class LongestArithSeqLength {

    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length == 0) return 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int j : A) {
            max = Math.max(max, j);
            min = Math.min(min, j);
        }
        int maxDiff = max - min;
        int[][] dp = new int[A.length][2 * maxDiff + 1];
        for (int i = 0; i < A.length; i++) {
            Arrays.fill(dp[i], 1);
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {

                dp[i][A[i] - A[j] + maxDiff] = Math.max(dp[i][A[i] - A[j] + maxDiff], dp[j][A[i] - A[j] + maxDiff] + 1);
                res = Math.max(dp[i][A[i] - A[j] + maxDiff], res);
            }
        }
        return res;
    }
}

package dp;

import java.util.Arrays;

public class LongestArithmeticSequence1027 {

    // 找到等差数列 在意其顺序
    public int longestArithSeqLength(int[] A) {
        // 找到最大最小值
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : A) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int res = 0;
        final int diff = max - min;
        // 表示以 A[i] 结尾的等差为 j 的等差数列的长度为多少
        // 将负数 移到整数范围
        int[][] dp = new int[A.length][diff * 2 + 1];
        for (int i = 0; i < A.length; i++) {
            Arrays.fill(dp[i], 1);
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                final int temp = A[i] - A[j] + diff;
                dp[i][temp] = Math.max(dp[i][temp], dp[j][temp] + 1);
                res = Math.max(res, dp[i][temp]);
            }
        }
        return res;
    }
}

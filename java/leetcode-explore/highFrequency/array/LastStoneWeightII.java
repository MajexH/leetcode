package highFrequency.array;

import java.util.Arrays;

public class LastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        int sum = Arrays.stream(stones).boxed().reduce(Integer::sum).get();
        // 前 i 个 能否形成 和 为 XXX
        boolean[][] dp = new boolean[stones.length + 1][sum / 2 + 1];
        // 初始化
        for (int i = 0; i <= stones.length; i++) {
            // 不管多少个和为 0 一定可以
            dp[i][0] = true;
        }
        int maxSum = 0;

        for (int i = 1; i <= stones.length; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                dp[i][j] = dp[i - 1][j] || (j >= stones[i - 1] && dp[i - 1][j - stones[i - 1]]);
                if (dp[i][j]) {
                    maxSum = Math.max(j, maxSum);
                }
            }
        }

        return sum - 2 * maxSum;
    }
}

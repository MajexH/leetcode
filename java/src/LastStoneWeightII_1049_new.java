import java.util.Arrays;

public class LastStoneWeightII_1049_new {

    public int lastStoneWeightII(int[] stones) {
        if (stones.length == 0) return 0;
        int sum = Arrays.stream(stones).sum();
        boolean[][] dp = new boolean[stones.length + 1][sum / 2 + 1];

        for (int i = 0; i <= stones.length; i++) {
            dp[i][0] = true;
        }

        int max = 0;
        for (int i = 1; i <= stones.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                dp[i][j] = dp[i - 1][j] || (j >= stones[i - 1] && dp[i - 1][j - stones[i - 1]]);
                if (dp[i][j]) max = Math.max(max, j);
            }
        }
        return sum - 2 * max;
    }
}

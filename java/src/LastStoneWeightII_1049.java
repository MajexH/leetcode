public class LastStoneWeightII_1049 {

    // 实际上这个问题就是问 怎么分类stones 让两个组的stone的差值最小
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        // dp[i][j] 表示前 i 个数能否形成和为 j
        boolean[][] dp = new boolean[stones.length + 1][sum / 2 + 1];
        for (int i = 0; i <= stones.length; i++) {
            dp[i][0] = true;
        }

        int maxSum = 0;
        for (int i = 1; i <= stones.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (j - stones[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stones[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                if (dp[i][j]) maxSum = Math.max(maxSum, j);
            }
        }

        return sum - 2 * maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new LastStoneWeightII_1049().lastStoneWeightII(new int[]{ 2,7,4,1,8,1 }));
    }
}

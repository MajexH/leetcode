package UniquePathsII63;

public class Solution {

    // 直接dp做吧
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[Math.max(i - 1, 0)][j] + dp[i][Math.max(j - 1, 0)];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] test = new int[3][3];
        test[1][1] = 1;
        System.out.println(new Solution().uniquePathsWithObstacles(test));
    }
}

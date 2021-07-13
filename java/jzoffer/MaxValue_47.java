public class MaxValue_47 {

    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dp[i][j] = Math.max(i - 1 >= 0 ? dp[i - 1][j] : 0, j - 1 >= 0 ? dp[i][j - 1] : 0) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}

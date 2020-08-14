package chapter5;

public class MaxValueOfPresent {

    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            dp[i] = new int[grid[i].length];
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.max(i - 1 >= 0 ? dp[i - 1][j] : 0, j - 1 >= 0 ? dp[i][j - 1] : 0);
                }
            }
        }
        return dp[grid.length - 1][grid[grid.length - 1].length - 1];
    }
}

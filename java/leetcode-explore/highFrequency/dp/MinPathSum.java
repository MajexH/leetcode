package highFrequency.dp;

import java.util.Arrays;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            dp[i] = new int[grid[i].length];
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                else dp[i][j] = Math.min(i - 1 < 0 ? Integer.MAX_VALUE : dp[i - 1][j], j - 1 < 0 ? Integer.MAX_VALUE : dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[grid.length - 1].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MinPathSum().minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }
}

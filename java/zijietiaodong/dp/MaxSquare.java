package dp;

import java.util.Arrays;
import java.util.Comparator;

public class MaxSquare {


    public int maximalSquare(char[][] matrix) {
        // dp[i][j] 表示以 matrix[i][j] 为右下角的 最小值
        int[][] dp = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            dp[i] = new int[matrix[i].length];
        }
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(
                            Math.min(i - 1 >= 0 ? dp[i - 1][j] : 0, i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] : 0),
                                    j - 1 >= 0 ? dp[i][j - 1] : 0
                            ) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSquare().maximalSquare(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        }));
    }
}

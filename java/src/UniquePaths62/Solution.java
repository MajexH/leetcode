package UniquePaths62;

import java.util.Arrays;

public class Solution {

    public int uniquePaths(int m, int n) {
//        return recursionWithOutMemo(m - 1, n - 1);
//        int[][] memo = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            memo[i] = new int[n];
//            Arrays.fill(memo[i], -1);
//        }
//        return recursionWithMemo(m - 1, n - 1, memo);
        return dpHelper(m, n);
    }

    // 不带备忘录的递归 超时
    public int recursionWithOutMemo(int curx, int cury) {
        // 表示走不通
        if (curx < 0 || cury < 0) return 0;
        // 表示这是一条可能的路线
        if (curx == 0 && cury == 0) return 1;
        return recursionWithOutMemo(curx - 1, cury) + recursionWithOutMemo(curx, cury - 1);
    }

    public int recursionWithMemo(int curx, int cury, int[][] memo) {
        if (curx < 0 || cury < 0) return 0;
        if (curx == 0 && cury == 0) {
            memo[curx][cury] = 1;
            return 1;
        }
        if (memo[curx][cury] != -1) {
            return memo[curx][cury];
        }
        memo[curx][cury] = recursionWithMemo(curx - 1, cury, memo) + recursionWithMemo(curx, cury - 1, memo);
        return memo[curx][cury];
    }

    // 采用dp dp[m][n] 表示在当前这个点的unique path是多少
    public int dpHelper(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化 到0 0点的时候 始终为1
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {continue;}
                // 状态转移方程
                dp[i][j] = dp[Math.max(i - 1, 0)][j] + dp[i][Math.max(j - 1, 0)];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(7, 3));
    }
}

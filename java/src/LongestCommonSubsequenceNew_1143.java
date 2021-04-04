public class LongestCommonSubsequenceNew_1143 {

    // 公共子序列的最长长度
    public int longestCommonSubsequence(String text1, String text2) {
        int res = 0;

        // dp[i][j] 表示 text1 i 之前的 text2 j 之前的能够形成的公共子序列长度
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}

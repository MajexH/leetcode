public class LongestCommonSubsequence_1143 {
    // 返回两个字符串的最长公共子序列的长度
    // 如 abcde ace 返回 3
    // 可以在 text1 和 text2 的公共最长长度
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 不等的情况的话 就从前面取最大的
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence_1143().longestCommonSubsequence("abcde", "ace"));
        System.out.println(new LongestCommonSubsequence_1143().longestCommonSubsequence("abc", "abc"));
        System.out.println(new LongestCommonSubsequence_1143().longestCommonSubsequence("abc", "def"));
    }
}

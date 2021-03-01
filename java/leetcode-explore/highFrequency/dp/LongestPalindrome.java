package highFrequency.dp;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        String res = "";
        // dp[i][j] 表示 i -> j 是否是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = i == j || i + 1 == j || dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}

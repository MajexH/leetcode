public class LongestPalindrome_5 {

    public String longestPalindrome(String s) {
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                dp[i][j] = i == j || ((s.charAt(i) == s.charAt(j) && (i + 1 == j || dp[i + 1][j - 1])));
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}

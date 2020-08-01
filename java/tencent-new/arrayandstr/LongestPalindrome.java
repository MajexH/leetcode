package arrayandstr;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        // dp[i][j] 表示从 i -> j 是否是一个回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        String maxLength = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            // 一个字符 肯定是回文串
            dp[i][i] = true;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = i == j || i + 1 == j || dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > maxLength.length()) {
                    maxLength = s.substring(i, j + 1);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("cbbd"));
    }
}

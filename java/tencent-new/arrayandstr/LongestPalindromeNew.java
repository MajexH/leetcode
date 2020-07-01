package str;

public class LongestPalindromeNew {

    public String longestPalindrome(String s) {
        // dp[i][j] 表示 string 从 i 到 j的是否是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];

        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i; j < s.length(); j++) {
                // 表示新的回文数
                if ((s.charAt(i) == s.charAt(j)) && (i == j || i + 1 == j || dp[i + 1][j - 1])) {
                    if (j - i + 1 > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                    dp[i][j] = true;
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromeNew().longestPalindrome("dabad"));
    }
}

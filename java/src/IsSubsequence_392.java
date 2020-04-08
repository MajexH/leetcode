import java.util.Arrays;

public class IsSubsequence_392 {

    public boolean isSubsequence(String s, String t) {
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            if (i == 0) Arrays.fill(dp[i], true);
            else Arrays.fill(dp[i], false);
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}

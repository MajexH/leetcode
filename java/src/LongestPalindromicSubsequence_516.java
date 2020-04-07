import java.util.Arrays;

public class LongestPalindromicSubsequence_516 {

    public int longestPalindromeSubseq(String s) {
        // dp[i][j] 表示 i 到 j 最长的回文数是多长
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], 0);
            // 一个字符 最长的回文数是自己
            dp[i][i] = 1;
        }
        // 这个地方必须从后向前 因为最后的结果 是 dp[0][s.length() - 1]
        // 所以首先要得到中间的结果
        for (int i = s.length() - 1; i >= 0 ; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                // 如果收尾想等 只需要知道它前面最长的回文数是多少即可
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 如果首尾不等 只需要知道 比它短一点的最长回文数是多少
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubsequence_516().longestPalindromeSubseq("cbbd"));
    }
}

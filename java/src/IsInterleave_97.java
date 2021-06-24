public class IsInterleave_97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        // 表示 s1 前 i 个 s2 前 j 个能不能交错的形成
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        dp[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                int i3 = i + j - 1;
                if (i >= 1) dp[i][j] = dp[i][j] || (s1.charAt(i - 1) == s3.charAt(i3) && dp[i - 1][j]);
                if (j >= 1) dp[i][j] = dp[i][j] || (dp[i][j - 1]  && s2.charAt(j - 1) == s3.charAt(i3));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    // s3 是否由 s1 s2 交错组成
    // 直接递归判断 看是否是一个能够交错形成的
    // 相当于形成了一颗二叉树 加上 memo 能够 97%
    public boolean isInterleaveWithMemo(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        int[][] memo = new int[s1.length()][s2.length()];
        return recursion(s1, s2, s3, 0, 0, 0, memo);
    }

    public boolean recursion(String s1, String s2, String s3, int i1, int i2, int i3, int[][] memo) {
        if (i3 == s3.length()) {
            return true;
        }
        if (i1 < s1.length() && i2 < s2.length() && memo[i1][i2] != 0) return memo[i1][i2] == 1;
        if (i1 >= s1.length() || s1.charAt(i1) != s3.charAt(i3)) {
            return i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3) && recursion(s1, s2, s3, i1, i2 + 1, i3 + 1, memo);

        }
        if (i2 >= s2.length() || s2.charAt(i2) != s3.charAt(i3)) {
            return i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3) && recursion(s1, s2, s3, i1 + 1, i2, i3 + 1, memo);
        }
        if (s1.charAt(i1) != s3.charAt(i3) && s2.charAt(i2) != s3.charAt(i3)) {
            memo[i1][i2] = -1;
            return false;
        }
        boolean flag = recursion(s1, s2, s3, i1, i2 + 1, i3 + 1, memo) || recursion(s1, s2, s3, i1 + 1, i2, i3 + 1, memo);
        memo[i1][i2] = flag ? 1 : -1;
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(new IsInterleave_97().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new IsInterleave_97().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(new IsInterleave_97().isInterleave("a", "", "c"));
    }
}

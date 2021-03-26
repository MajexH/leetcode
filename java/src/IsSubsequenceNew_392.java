public class IsSubsequenceNew_392 {

    // 贪心的来做
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        // 每次只要一匹配 s 串字符下标就向后移动 发那么最后如果遍历完毕 s 到达末尾 就可以知道 一定是 subsequence
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    // dp 来做
    public boolean isSubsequenceWithDp(String s, String t) {
        int m = t.length(), n = s.length();

        // 表示前 i 个 t 字符 和 前 j 个 s 字符 能否形成子序列
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 初始化
        for (int i = 0; i <= m; i++) {
            // s 串为 空 t 中一定可以找到
            dp[i][0] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 首先是判断当前 j 长度的 s 是否已经在 i - 1 前找到 那么就可以吧这个状态给延续下来
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    // 这个时候 如果对应的字符相等的 只需要再次找到 i - 1 j - 1 的状态 转移过来即可
                    dp[i][j] = dp[i][j] || dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}

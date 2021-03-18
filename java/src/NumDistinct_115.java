public class NumDistinct_115 {

    // 找到 t 在 s 中有几种不同的序列组合方式
    // 如 s = "rabbbit", t = "rabbit"
    // 有 3 种可以从 s 中得到 "rabbit" 的方案。
    //(上箭头符号 ^ 表示选取的字母)
    //  rabbbit
    //  ^^^^ ^^
    //  rabbbit
    //  ^^ ^^^^
    //  rabbbit
    //  ^^^ ^^^
    public int numDistinct(String s, String t) {
        if (s == null || t == null) return 0;

        // dp[i][j] 表示 t[j] 之前的序列能够在 s[i] 之前的形成子序列匹配次数
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // 初始化
        for (int i = 0; i <= s.length(); i++) {
            // t 为 "" 不管 s 是什么都可以组成一个
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                // 转移的话
                // 1. s[i - 1] == t[j - 1]
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 可以选择让自己加入到这个匹配中 或者自己不匹配 看之前这个长度的匹配数量 进行转移
                    dp[i][j] += dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // 这时候不等 说明 要找之前同样 t 长度的 串
                    // 在上个 i-1 时刻能够匹配的大小
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        System.out.println(new NumDistinct_115().numDistinct("rabbbit", "rabbit"));
        System.out.println(new NumDistinct_115().numDistinct("babgbag", "bag"));
    }
}

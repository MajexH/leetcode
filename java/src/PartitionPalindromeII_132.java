import java.util.Arrays;

public class PartitionPalindromeII_132 {

    // 把一个字符串 分隔成回文串的 组合 要多少次分隔
    public int minCut(String s) {
        // dp[i][j] 表示从 i 到 j 的字符串是否是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            // 初始化 一个字符 肯定是回文串
            dp[i][i] = true;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = i == j || i + 1 == j || dp[i + 1][j - 1];
                }
            }
        }
        // cuts[i] 表示 s 字符串从 i 到字符串的结尾要切几次才能是一个回文串
        int[] cuts = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            // 整个是回文串 那就意味着不用切割
            if (dp[i][s.length() - 1]) {
                cuts[i]= 0;
                continue;
            }
            int min = Integer.MAX_VALUE;
            // 要不然找到一个能够从 i ->j 形成回文串的点，保存j + 1 之后的 cuts 需要的长度
            // 比较其中的最小值
            for (int j = i; j < s.length() - 1; j++) {
                if (dp[i][j])
                    min = Math.min(min, cuts[j + 1]);

            }
            cuts[i] = min + 1;
        }
        return cuts[0];
    }

    public static void main(String[] args) {
        System.out.println(new PartitionPalindromeII_132().minCut("leet"));
    }
}

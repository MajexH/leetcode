import java.util.Arrays;

public class PartitionParlindromII_132 {

    // 返回将 s 分割成一个回文子串需要的最少的分割次数
    public int minCut(String s) {
        int[] dp = new int[s.length()];

        // 这个地方初始化是因为这个原因
        // 因为一个数肯定是可以成为回文数的
        // 因此 一个 n 位的数，如果成为回文数
        // 最大的次数可能就是这 n 位数 一个一个 单独成 也就是需要 n - 1 次划分
        // 这里就初始化成最大需要划分的次数
        for (int i = 0; i < s.length(); i++) {
            dp[i] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            if (checkPalindrome(s, 0, i)) {
                dp[i] = 0;
            } else {
                // j 代表分割的地方
                for (int j = 1; j <= i; j++) {
                    if (checkPalindrome(s, j, i)) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }

    public boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionParlindromII_132().minCut("aab"));
    }
}

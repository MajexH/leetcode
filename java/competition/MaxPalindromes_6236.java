package competition;

public class MaxPalindromes_6236 {

    public static void main(String[] args) {
        System.out.println(new MaxPalindromes_6236().maxPalindromes("abaccdbbd", 3));
        System.out.println(new MaxPalindromes_6236().maxPalindromes("adbcda", 2));
        System.out.println(new MaxPalindromes_6236().maxPalindromes("sjbxiufnaanqkwsqswkqrcznzcddhtuhtthuttjfuufjtcfywgecegwyhhnnhtozczirynhhnyrire", 3));
    }

    public int maxPalindromes(String s, int k) {

        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                isPalindrome[i][j] = (i == j || i + 1 == j || isPalindrome[i + 1][j - 1]) && s.charAt(i) == s.charAt(j);
            }
        }

        int[] dp = new int[s.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            // 当前可以直接由上一个转化
            dp[i] = dp[i - 1];
            for (int j = i - 1; j >= 0; j--) {
                if (isPalindrome[j][i - 1] && i - j >= k) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[s.length()];
    }
}

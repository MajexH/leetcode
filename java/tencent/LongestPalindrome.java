import java.util.Arrays;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        // 表示 i j 之前是否是回文数
        boolean[][] memo = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            // 这个地方是因为一个数 自然成回文数
            memo[i][i] = true;
        }
        String max = "";
        // 这个地方必须从后往前 因为 memo[i + 1][j - 1] 可能会存在还未访问的情况（从前往后的话）
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    memo[i][j] = j == i || j == i + 1 || memo[i + 1][j - 1];
                }

                if (memo[i][j] && j - i + 1 > max.length()) {
                    max = s.substring(i, j + 1);
                }
            }
        }
        //System.out.println(Arrays.deepToString(memo));
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("aaaa"));
    }
}

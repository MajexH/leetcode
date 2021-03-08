import java.util.Arrays;

public class PartitionPalindromeIINew_132 {

    public int minCut(String s) {

        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && (i == j || i + 1 == j || isPalindrome[i + 1][j - 1]);
            }
        }

        int[] minCut = new int[s.length()];
        // 默认所有的都是不可分割的
        Arrays.fill(minCut, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome[0][i]) {
                minCut[i] = 0;
                continue;
            }
            for (int j = 1; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    minCut[i] = Math.min(minCut[j - 1] + 1, minCut[i]);
                }
            }
        }
        return minCut[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new PartitionPalindromeIINew_132().minCut("aab"));
    }
}

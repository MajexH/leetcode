public class MinCut_132 {

    public int minCut(String s) {

        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && (i == j || i + 1 == j || isPalindrome[i + 1][j - 1]);
            }
        }


        int[] minCuts = new int[s.length()];
        // 初始化
        for (int i = 0; i < minCuts.length; i++) {
            // 最大的肯定是一个字母就是回文串
            minCuts[i] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome[0][i]) {
                minCuts[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j + 1][i]) {
                    minCuts[i] = Math.min(minCuts[i], minCuts[j] + 1);
                }
            }
        }
        return minCuts[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MinCut_132().minCut("aab"));
    }
}

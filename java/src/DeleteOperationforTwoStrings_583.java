public class DeleteOperationforTwoStrings_583 {

    /**
     * 这个删除字符就是找到 word1 和 word2 的公共子串（非连续的）
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 最大的长度
        int maxLength = 0;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 这是两个状态
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return word1.length() + word2.length() - 2 * maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new DeleteOperationforTwoStrings_583().minDistance("sea", "eat"));
    }
}

public class MaxUncrossedLines_1035 {

    // dp 问题 最长公共子序列
    // nums1 nums2 中形成的最长的公共子序列
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // dp[i][j] 表示 nums1[i-1] nums2[j-1] 能够形成的最长公共子序列长度
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    // 把数值传递下去
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }

    public static void main(String[] args) {
        System.out.println(new MaxUncrossedLines_1035().maxUncrossedLines(new int[]{3}, new int[]{3,3,4}));
        System.out.println(new MaxUncrossedLines_1035().maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}));
        System.out.println(new MaxUncrossedLines_1035().maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));
    }
}

import java.util.Arrays;

public class NumberofLongestIncreasingSubsequence_673_new {

    public int findNumberOfLIS(int[] nums) {
        // counts[i] 表示以 nums[i] 结果的递增子序列的个数
        int[] counts = new int[nums.length];
        // dp[i] 表示以 nums[i] 结尾的递增子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(counts, 1);
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 应该在这里更新 因为可能会有重复
                if (nums[j] < nums[i]) {
                    // 说明最长的长度 需要更新
                    if (dp[j] >= dp[i]) {
                        counts[i] = counts[j];
                        dp[i] = dp[j] + 1;
                    } else if (dp[j] + 1 == dp[i]){
                        // 说明两个的最长长度只相差1 如果 j 里面在算上 i 就是最长长度
                        counts[i] += counts[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == maxLength) res += counts[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumberofLongestIncreasingSubsequence_673_new().findNumberOfLIS(new int[]{2,2,2,2,2}));
    }
}

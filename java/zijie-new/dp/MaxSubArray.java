package dp;

public class MaxSubArray {

    /**
     * 找到一个具有最大和的连续子数组 (一定是连续的)
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        // 表示前面的最大和是多少
        int[] dp = new int[nums.length + 1];
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (dp[i] < 0) {
                dp[i + 1] = nums[i];
            } else {
                dp[i + 1] = dp[i] + nums[i];
            }
            maxSum = Math.max(maxSum, dp[i + 1]);
        }

        return maxSum;
    }
}

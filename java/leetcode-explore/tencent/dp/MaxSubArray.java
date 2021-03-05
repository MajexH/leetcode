package tencent.dp;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i - 1];
            } else {
                dp[i] = dp[i - 1] + nums[i - 1];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}

import java.util.Arrays;

public class MaxSubArray_42 {

    // 子数组能够形成的最大和
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || dp[i - 1] < 0) dp[i] = nums[i];
            else dp[i] = dp[i - 1] + nums[i];

            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray_42().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}

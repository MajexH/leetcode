public class CombinationSumIV_377 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int num : nums) {
            if (num >= 0 && num <= target) dp[num] = 1;
        }
        for (int i = 2; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}

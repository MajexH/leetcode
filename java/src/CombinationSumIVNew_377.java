import java.util.Arrays;

public class CombinationSumIVNew_377 {

    public int combinationSum4(int[] nums, int target) {
        // dp[i] 表示和为 i 的数能够形成的组合数
        int[] dp = new int[target + 1];
        // 和为 0 的情况只有一种 那就是什么都不选
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                // 这个地方其实就是累加前面的结果，用nums[j] 作为 0 -> i 的分界点
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIVNew_377().combinationSum4(new int[]{1,2,3},4));
    }
}

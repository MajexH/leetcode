package ali;

public class CombinationSum4 {

    // nums 中不含有重复的数字 问能够组成 target 的组合个数
    public int combinationSum4(int[] nums, int target) {
        // 完全背包问题
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            // 必须从后向前 防止重复
            for (int j = nums.length - 1; j >= 0; j--) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum4().combinationSum4(new int[]{1,2,3}, 4));
        System.out.println(new CombinationSum4().combinationSum4(new int[]{1,2,3}, 3));
    }
}

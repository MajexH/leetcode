public class CombinationSumIV_New_377 {

    // 完全背包
    // 如果有负数 dp 会越界 因此只需要加上最小的负数的偏移即可
    public int combinationSum4(int[] nums, int target) {
        // dp[i] 表示 和为 i 的能有几个组成
        int[] dp = new int[target + 1];
        // 兜底
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIV_New_377().combinationSum4(new int[]{1,2,3},4));
    }
}

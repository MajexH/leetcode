public class HouseRobber_198 {

    public int rob1(int[] nums) {
        if (nums.length <= 0) return 0;
        // 保存前拿了前一个的最大值
        int take = nums[0];
        // 保存不拿前一个的最大值
        int notTake = 0;
        for (int i = 1; i < nums.length; i++) {
            int preTake = take;
            take = notTake + nums[i];
            notTake = Math.max(preTake, notTake);
        }
        return Math.max(take, notTake);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length == 1) return dp[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        int[] take = new int[nums.length], notTake = new int[nums.length];
        take[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            take[i] = notTake[i - 1] + nums[i];
            notTake[i] = Math.max(take[i - 1], notTake[i - 1]);
        }
        return Math.max(take[take.length - 1], notTake[notTake.length - 1]);
    }
}

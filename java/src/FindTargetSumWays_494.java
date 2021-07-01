import java.util.Arrays;

public class FindTargetSumWays_494 {

    // 添加 + - 号 问有几种方案可以得到其结果为 target
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = Arrays.stream(nums).boxed().reduce(Integer::sum).get();
        // 越界
        if (target > sum || target < -sum) return 0;
        int[] dp = new int[2 * sum + 1];
        dp[0 + sum] = 1;

        for (int num : nums) {
            int[] next = new int[2 * sum + 1];
            for (int j = 0; j <= 2 * sum; j++) {
                if (dp[j] != 0) {
                    next[j + num] += dp[j];
                    next[j - num] += dp[j];
                }
            }
            dp = next;
        }
        return dp[target + sum];
    }

    // 直接递归是可以过的
    private int count = 0;

    public int findTargetSumWaysRecursion(int[] nums, int target) {
        recursion(nums, 0, target);
        return this.count;
    }

    public void recursion(int[] nums, int index, int target) {
        if (index == nums.length) {
            if (target == 0) this.count++;
            return;
        }
        recursion(nums, index + 1, target - nums[index]);
        recursion(nums, index + 1, target + nums[index]);
    }
}

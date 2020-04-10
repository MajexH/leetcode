public class TargetSum_494 {

    private int count = 0;

    public int findTargetSumWays(int[] nums, int s) {
        // 保存 nums 的和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 越界 不可能
        if (s > sum || s < -sum) return 0;
        // 为什么是 2 * sum 因为有正负两遍
        // dp[i] 表示和为 j(需要加上一个sum的偏移) 的值的数量
        int[] dp = new int[2 * sum + 1];
        // 表示和为sum的有一种 （就是上面说的哪一种 实际上其对应的本来应该是 和为0 的位置 有sum的偏移）
        dp[0 + sum] = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] next = new int[2 * sum + 1];
            for (int j = 0; j < 2 * sum + 1; j++) {
                // 表示这个地方已经被访问过了 也就是一个可能的值
                if (dp[j] != 0) {
                    next[j - nums[i]] += dp[j];
                    next[j + nums[i]] += dp[j];
                }
            }
            dp = next;
        }

        return dp[s + sum];
    }

    public int findTargetSumWays1(int[] nums, int S) {
        recursion(S, nums, 0, 0);
        return this.count;
    }

    public void recursion(int target, int[] nums, int index, int current) {
        if (index == nums.length) {
            if (target == current) this.count++;
            return;
        }

        recursion(target, nums, index + 1, current + nums[index]);
        recursion(target, nums, index + 1, current - nums[index]);
    }

    public static void main(String[] args) {
        System.out.println(new TargetSum_494().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}

public class PartitionEqualSubsetSum_416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        // dp[i][j] 表示 前 i 个能否形成和为 j 的结果
        boolean[][] dp = new boolean[nums.length + 1][sum / 2 + 1];
        // 0个数字可以组成和为0的
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][sum / 2];
    }

    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum_416().canPartition(new int[]{ 1, 5, 11, 9 }));
    }
}

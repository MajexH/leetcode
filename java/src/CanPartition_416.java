import java.util.Arrays;

public class CanPartition_416 {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int sum = Arrays.stream(nums).boxed().reduce(Integer::sum).get();
        // 和必须是偶数
        if ((sum & 1) == 1) return false;
        // nums 能不能分成两块和相等的
        // 前 i 个的和 能否形成 和 为 sum / 2 的结果
        boolean[][] dp = new boolean[nums.length + 1][sum / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum / 2; j >= 0; j--) {
                // 传递之前的状态
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][sum / 2];
    }

    public static void main(String[] args) {
        System.out.println(new CanPartition_416().canPartition(new int[]{1,5,11,5}));
        System.out.println(new CanPartition_416().canPartition(new int[]{1,2,3,5}));
    }
}

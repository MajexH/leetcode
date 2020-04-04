import java.util.Arrays;

public class LongestNumberSequence {

    // 给定一个数组 找到其最长的 等差数列 的长度 无所谓其数字的顺序
    public int longestNumberSequence(int n, int[] nums) {
        Arrays.sort(nums);
        int maxDiff = nums[nums.length - 1] - nums[0];
        // dp[i][j] 表示 前i个数 能够形成的等差为j的数量
        int[][] dp = new int[nums.length][maxDiff + 1];
        for (int i = 0; i < nums.length; i++) {
            // 任何数和自己做等差数列的长度都是1
            Arrays.fill(dp[i], 1);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][nums[i] - nums[j]] = Math.max(dp[i][nums[i] - nums[j]], dp[j][nums[i] - nums[j]] + 1);
                res = Math.max(res, dp[i][nums[i] - nums[j]]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestNumberSequence().longestNumberSequence(5, new int[]{1,3,5,7,8,10, 6}));
    }
}

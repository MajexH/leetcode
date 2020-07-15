import java.util.Arrays;

public class LongestIncreasingSubsequenceNew_300 {

    // 给定一个数组 找到其最长递增序列
    public int getLongestIncreasingSubsequence(int[] nums) {
        if (nums == null) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        // 自己一个肯定是递增的
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    temp = Math.max(temp, dp[j]);
            }
            dp[i] = temp + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequenceNew_300().getLongestIncreasingSubsequence(new int[]{ 10,9,2,5,3,7,101,18 }));
    }
}

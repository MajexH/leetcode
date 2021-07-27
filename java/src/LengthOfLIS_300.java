import java.util.Arrays;

public class LengthOfLIS_300 {

    // 最长递增子序列 o(n^2)
    public int lengthOfLISBruteForce(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLIS_300().lengthOfLISBruteForce(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}

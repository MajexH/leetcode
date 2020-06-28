package dp;

import java.util.Arrays;

/**
 *
 * @author majexh
 */
public class LongestProgression {

    /**
     * 找到最长的等差数列 无所谓其顺序
     * @param nums
     * @return
     */
    public int getLongestProgression(int[] nums) {
        Arrays.sort(nums);

        int maxDiff = nums[nums.length - 1] - nums[0];
        int res = 0;
        // dp[i][j] 表示前 i 个能够形成的最大的等差为 j 的等差数列 长度为多少
        int[][] dp = new int[nums.length][maxDiff + 1];
        for (int i = 0; i < nums.length; i++) {
            // 自己跟自己等差 等差说是 多少都可以 因此是1
            Arrays.fill(dp[i], 1);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 跟子串比较 哪个更大去哪个
                dp[i][nums[i] - nums[j]] = dp[j][nums[i] - nums[j]] + 1;
                res = Math.max(res, dp[i][nums[i] - nums[j]]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestProgression().getLongestProgression(new int[]{ 1, 4, 2, 5, 3 }));
    }
}

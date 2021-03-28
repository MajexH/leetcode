package meituan;

import java.util.Scanner;

public class GetRoundMaxLenSum {

    // 在循环数组中找到下标最大的值
    // 所以分别求数组的连续最小和（sum - 连续最小和即为连续最大和） 和 连续最大和
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (; T > 0; T--) {
            // 注意的是循环数组
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int sum = nums[0];
            int max1 = nums[0];
            int[] dp = new int[n];
            dp[0] = nums[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                max1 = Math.max(max1, dp[i]);
                sum += nums[i];
            }

            // 连续最小和
            int min1 = nums[0];
            int[] mins = new int[n];
            mins[0] = nums[0];

            for (int i = 1; i < n; i++) {
                dp[i] = Math.min(dp[i - 1] + nums[i], nums[i]);
                min1 = Math.min(min1, dp[i]);
            }

            System.out.println(Math.max(sum - min1, max1));
        }
    }
}

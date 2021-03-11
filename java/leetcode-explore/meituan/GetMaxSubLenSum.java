package meituan;

import java.util.Scanner;

public class GetMaxSubLenSum {

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
            int max = Integer.MIN_VALUE;;

            // 因为是连续的 所以扩展到 2 倍长度即可遍历完
            // 但是这样直接往上添加的话 相当于直接填了一个数组 会造成结果不对
            // o(n^2) 算法超时
            // 其思想是遍历作为起始节点的 数组中的点
//            for (int start = 0; start < n; start++) {
//                int[] dp = new int[n];
//                for (int i = start; i < start + n; i++) {
//                    int realIndex = i % n;
//                    int dpIndex = i - start;
//                    if (dpIndex == 0 || dp[dpIndex - 1] < 0) {
//                        dp[dpIndex] = nums[realIndex];
//                    } else {
//                        dp[dpIndex] = dp[dpIndex - 1] + nums[realIndex];
//                    }
//                    max = Math.max(dp[dpIndex], max);
//                }
//            }

            // 统一从左向右能够形成的最大值 和 从右想左能够形成的最大值
            // 然后加起来比较即可
            // 根据就两种情况
            // 1 是 在这个区间上连续的i
            // 先计算在这个区间上连续的最大值
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                if (i == 0 || dp[i - 1] < 0) {
                    dp[i] = nums[i];
                } else {
                    dp[i] = dp[i - 1] + nums[i];
                }
                max = Math.max(dp[i], max);
            }

            // 2 是 跨区域连续的
            // 跨区域的话 分别找到 从左向右 从右向左的连续最大值即可
            int[] left = new int[n];
            int[] leftMax = new int[n];
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    left[i] = nums[i];
                } else {
                    left[i] = left[i - 1] + nums[i];
                }

                leftMax[i] = i == 0 ? left[i] : Math.max(leftMax[i - 1], left[i]);
            }

            int[] right = new int[n];
            int[] rightMax = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                if (i == n - 1) {
                    right[i] = nums[i];
                } else {
                    right[i] = right[i + 1] + nums[i];
                }

                rightMax[i] = i == n - 1 ? right[i] : Math.max(rightMax[i + 1], right[i]);
            }

            int transferMax = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    transferMax = Math.max(leftMax[i], transferMax);
                } else {
                    transferMax = Math.max(transferMax, leftMax[i] + rightMax[i + 1]);
                }
            }

            System.out.println(Math.max(max, transferMax));
        }
    }
}

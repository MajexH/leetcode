package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class FillNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt(), d = sc.nextInt();

        int[] dp = new int[n + 1];
        // 至少可以由自己组成
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // 超过 k 值的 不能填入
                // 必须保证有一个数大于 d 值
//                if (j > k) continue;
//                if (j < d && i - j < d) continue;
                dp[i] += dp[j];
            }
        }
        System.out.println(dp[n]);
    }
}

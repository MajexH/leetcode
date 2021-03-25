package meituan;

import java.util.Scanner;

public class IsSubString {


    // 直接贪心
    public static void main(String[] args) {
        // 判断子序列
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        String s = sc.next(), t = sc.next();

        // 贪心的 计算最小的匹配和 首先匹配到的计入结果
        int i = 0, j = 0;
        // 注意爆 int
        long res = 0;

        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                res += i;
            } else {
                i++;
            }
        }
        if (j == m) {
            System.out.printf("%s\n%d\n", "Yes", res);
        } else {
            System.out.println("No");
        }
    }

    // 第一次尝试的解法 直接通过 dp 来做 判断是否是需要的
    public static void First() {
        // 判断子序列
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        String s = sc.next(), t = sc.next();

        // 判断是否是子序列
        boolean[][] dp = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            // t 是空串是一定可以的
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 已经找到了一个相等的地方
                    // 相等的话 可以用这个相等的两个字符匹配 或者 之前的匹配
                    dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j];
                } else {
                    // 那么只能看之前的字符串是否匹配
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        if (dp[n][m]) {
            System.out.println("Yes");
            // 要计算最小的匹配和
            int i = 0, j = 0;
            int res = 0;

            while (i < n && j < m) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                    res += i;
                } else {
                    i++;
                }
            }
            System.out.println(res);
        } else {
            System.out.println("No");
        }
    }
}

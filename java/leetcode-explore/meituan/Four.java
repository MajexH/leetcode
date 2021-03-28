package meituan;

import java.util.Scanner;

public class Four {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = i; j < Math.min(n, i + k); j++) {
                tmp ^= nums[j];
                res = Math.max(res, tmp);
            }
        }

        System.out.println(res);
    }
}

package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Second {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), c1 = sc.nextInt(), c2 = sc.nextInt();

        int c = Math.min(c1, c2);

        String str = sc.next();

        long res = 0;
        // 只要超过三条的才加入
        int preIndex = -1;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'F') {
                if (preIndex == -1) preIndex = i;
            } else {
                if (preIndex != -1) {
                    int len = i - preIndex;
                    if (len >= 3) {
                        res += (long) c * (len / 3);
                    }
                    preIndex = -1;
                }
            }
        }

        if (preIndex != -1) {
            int len = n - preIndex;
            if (len >= 3) {
                res += (long) c * (len / 3);
            }
        }
        System.out.println(res);
    }
}

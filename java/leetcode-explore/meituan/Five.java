package meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Five {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] trees = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            trees[i] = sc.nextInt();
        }

        List<Integer> res = new ArrayList<>();

        int[] left = new int[n + 1];
        // 只有编号重新来过
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {
                left[i] = (i - 2 < 0 ? 0 : left[i - 2]) + trees[i];
            } else {
                left[i] = left[i - 2] + trees[i];
            }
        }
        int[] right = new int[n + 1];

        for (int i = n; i >= 1; i--) {
            right[i] = (i + 2 > n ? 0 : right[i + 2]) + trees[i];
        }

        // 遍历
        for (int i = 1; i <= n; i++) {
            // 用 i 来爬
            int num = trees[i];

            int l = left[i] - num + (i == n ? 0 : right[i + 1]);
            int r = left[i - 1] + right[i] - num;
            if (l == r) res.add(i);
        }

        if (res.size() == 0) {
            System.out.println(0);
        } else {
            System.out.println(res.size());
            StringBuilder builder = new StringBuilder();
            for (int a : res) {
                builder.append(a);
                builder.append(" ");
            }
            System.out.println(builder.toString().trim());
        }
    }
}

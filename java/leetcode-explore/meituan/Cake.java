package meituan;

import java.io.*;
import java.util.Scanner;

public class Cake {

    // 一天烤蛋糕
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        while (sc.hasNext()) {
            // n 一天生产的蛋糕数 m 现在生产的蛋糕数 a b 范围
            int n = sc.nextInt(), m = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
            if (a > b) {
                a = a ^ b;
                b = a ^ b;
                a = a ^ b;
            }

            // 已经生产的是否与 a或者b 相等
            boolean matchA = false, matchB = false;
            boolean outOfRange = false;
            for (int i = 0; i < m; i++) {
                int tmp = sc.nextInt();
                if (tmp < a || tmp > b) {
                    outOfRange = true;
                }
                if (tmp == a) matchA = true;
                if (tmp == b) matchB = true;
            }
            if (outOfRange) {
                out.write("NO");
                out.newLine();
                continue;
            }
            if (matchA && matchB) {
                out.write("YES");
                out.newLine();
                continue;
            }
            int need = (matchA ? 0 : 1) + (matchB ? 0 : 1);
            // 现在就是看剩下的数量是否能够满足 生成 a 或者 b 的数量
            if (need <= n - m) {
                out.write("YES");
            } else {
                out.write("NO");
            }
            out.newLine();
        }
        out.flush();
    }
}

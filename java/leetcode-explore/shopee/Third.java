package shopee;

import java.util.Arrays;
import java.util.Scanner;

public class Third {

    private static class Stair {
        int index, to;
        boolean isD;

        public Stair(int index) {
            this.index = index;
            this.to = -1;
            this.isD = false;
        }

        public Stair(int index, boolean isD) {
            this.index = index;
            this.to = -1;
            this.isD = isD;
        }

        public Stair(int index, int to) {
            this.index = index;
            this.to = to;
            this.isD = false;
        }
    }

    private static int recursion(Stair[] stairs, int index, int n, int[] memo) {
        if (index == n) {
            // 到达
            return 1;
        }
        if (index > n) return 0;
        if (memo[index] != -1) return memo[index];
        int res = 0;
        if (index + 1 < stairs.length) {
            if (!stairs[index + 1].isD) {
                res = (res + recursion(stairs, index + 1, n, memo)) % 20212021;
                if (stairs[index + 1].to != -1) {
                    res =(res + recursion(stairs, stairs[index + 1].to, n, memo)) % 20212021;
                }
            }
        } else {
            res = (res + recursion(stairs, index + 1, n, memo)) % 20212021;
        }

        if (index + 2 < stairs.length) {
            if (!stairs[index + 2].isD) {
                res = (res + recursion(stairs, index + 2, n, memo)) % 20212021;
                if (stairs[index + 2].to != -1) {
                    res = (res + recursion(stairs, stairs[index + 2].to, n, memo)) % 20212021;
                }
            }
        } else {
            res = (res + recursion(stairs, index + 2, n, memo)) % 20212021;
        }
        memo[index] = res;
        return memo[index];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), d = sc.nextInt(), m = sc.nextInt();

        Stair[] stairs = new Stair[n];
        for (int i = 0; i < n; i++) {
            stairs[i] = new Stair(i);
        }

        for (int i = 0; i < d; i++) {
            int index = sc.nextInt();
            stairs[index] = new Stair(index, true);
        }

        for (int j = 0; j < m; j++) {
            int from = sc.nextInt(), to = sc.nextInt();
            stairs[from] = new Stair(from, to);
        }
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        System.out.println(recursion(stairs, 0, n, memo));
    }
}

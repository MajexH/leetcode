import java.util.Arrays;
import java.util.Scanner;

public class niuniuBag {

    public static int recursion(int n, long w, long[] weights) {
        if (n == 0) {
            return 1;
        }
        int sum = 0;
        if (w >= weights[n - 1])
            sum += recursion(n - 1, w - weights[n - 1], weights);
        sum += recursion(n - 1, w, weights);
        return sum;
    }

    /**
     * 牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
     * 牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
     * 牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long w = scanner.nextLong(), sum = 0;
        long[] weights = new long[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextLong();
            sum += weights[i];
        }
        if (sum <= w) {
            System.out.format("%.0f", Math.pow(2, n));
            return;
        }
        // dp 是不不科学的 因为W 有 2 * 10^9
        // dp[i] 表示 i 个容量的背包有几种
//        int[] dp = new int[(int) (w + 1)];
//        // 总体积为0 也算1种
//        dp[0] = 1;
//        for (long weight : weights) {
//            for (int i = 1; i <= w; i++) {
//                if (i >= weight) {
//                    // 代表要
//                    dp[i] += dp[(int) (i - weight)];
//                } else {
//                    // 代表不要
//                    dp[i] += 1;
//                }
//            }
////            System.out.println(Arrays.toString(dp));
//        }
////        System.out.println(Arrays.toString(dp));
//        System.out.println(dp[(int) w]);
        System.out.println(recursion(n, w, weights));
    }
}

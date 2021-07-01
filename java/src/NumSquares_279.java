import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumSquares_279 {

    // 可以直接用动态规划
    public int numSquares(int n) {
        if (n == 0 || n == 1) return n;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // 找到完全平方数
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }
        return dp[n];
    }

    public int numSquaresOptimize(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        List<Integer> squares = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        for (int i = 1; i <= n; i++) {
            // 优化的点是在这儿 优化的是第二个循环分隔的地方
            // 因为一个数 一定可以表达为一个数 + 一个完全平方数
            // 而完全平方数的数量 比 n 小指数个数量级 所以这样做
            for (int j = squares.size() - 1; j >= 0; j--) {
                if (i >= squares.get(j)) dp[i] = Math.min(dp[i], dp[i - squares.get(j)] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new NumSquares_279().numSquaresOptimize(12));
        System.out.println(new NumSquares_279().numSquaresOptimize(13));
    }
}

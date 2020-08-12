package algorithmInterview.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquare {

    // 这个不同于下面那个解法
    // 是在 squares 上遍历 遍历更快
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 到达 0 的方法只有 0 种
        dp[0] = 0;
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = squares.size() - 1; j >= 0; j--) {
                if (i >= squares.get(j)) {
                    dp[i] = Math.min(dp[i], dp[i - squares.get(j)] + 1);
                }
            }
        }
        return dp[n];
    }

    // ac 解法 只是时间有点长
    // 从数字本身出发 找到数字的分割点 然后分别加上左右数字 能够被组成的最小值
    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquare().numSquares(12));
    }

}

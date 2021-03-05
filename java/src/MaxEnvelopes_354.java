import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxEnvelopes_354 {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return -1;
        }
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        // 现在就变成了一个寻找最长递增子序列的问题
        // 因为他要求的是前一个的长已经满足 所以是宽度上的最长递增西序列
        int res = 1;
        int[] dp = new int[envelopes.length];
        // 每个数的最长递增子序列肯定是自己 初始化
        Arrays.fill(dp, 1);
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(dp[i], res);
            }
        }
        return res;
    }
}

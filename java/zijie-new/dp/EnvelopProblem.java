package dp;

import java.util.Arrays;

public class EnvelopProblem {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            else return a[0] - b[0];
        });
        // System.out.println(Arrays.deepToString(envelopes));
        int max = 0;
        // 最长递减数列
        int[] dp = new int[envelopes.length];
        // 最短都是一个的长度 也即是自己成为一个
        Arrays.fill(dp, 1);
        for (int i = 0; i < envelopes.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1])
                    temp = Math.max(temp, dp[j]);
            }
            dp[i] = temp + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new EnvelopProblem().maxEnvelopes(new int[][]{
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        }));
    }
}

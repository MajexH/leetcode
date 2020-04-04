import Subsets78.Solution;

import java.util.Arrays;

public class BagProblems {

    // 01背包
    public int zeroOneBag(int[] weights, int[] values, int capacity) {
        // dp[i] 表示i的capacity下能够形成的最大值
        int[] dp = new int[capacity + 1];
        Arrays.fill(dp, 0);
        for (int j = 0; j < weights.length; j++) {
            for (int i = capacity; i >= 0; i--) {
                if (i >= weights[j])
                    dp[i] = Math.max(dp[i], dp[i - weights[j]] + values[j]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[capacity];
    }

    public int completeBag(int[] weights, int[] values, int capacity) {
        // dp[i] 表示i的capacity下能够形成的最大值
        int[] dp = new int[capacity + 1];
        Arrays.fill(dp, 0);
        for (int i = 1; i <= capacity; i++) {
            for (int j = 0; j < weights.length; j++) {
                if (i >= weights[j])
                    dp[i] = Math.max(dp[i], dp[i - weights[j]] + values[j]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] values = new int[]{ 6,10,12 };
        int[] weights = new int[]{ 1,2,3 };
        System.out.println(new BagProblems().zeroOneBag(weights, values, 5));
        System.out.println(new BagProblems().completeBag(weights, values, 5));
    }
}

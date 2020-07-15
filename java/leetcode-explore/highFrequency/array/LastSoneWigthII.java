package highFrequency.array;

import java.util.Arrays;

public class LastSoneWigthII {

    // 这道题其实就是问 能不能把这个数组分成两份相等的
    // 也就是能不能平分数组
    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0) return -1;
        int sum = Arrays.stream(stones).reduce(Integer::sum).getAsInt();
        boolean[][] dp = new boolean[stones.length + 1][sum / 2 + 1];
        for (int i = 0; i < stones.length; i++) {
            dp[i][0] = true;
        }

        // 01 背包 这儿是
        for (int i = 1; i <= stones.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (j >= stones[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stones[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[stones.length][i]) {
                return sum - i * 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new LastSoneWigthII().lastStoneWeightII(new int[]{31,26,33,21,40}));
    }
}

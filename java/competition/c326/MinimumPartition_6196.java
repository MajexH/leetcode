package competition.c326;

import java.util.Arrays;

public class MinimumPartition_6196 {

    public static void main(String[] args) {
        MinimumPartition_6196 solution = new MinimumPartition_6196();
        System.out.println(solution.minimumPartition("165462", 60));
        System.out.println(solution.minimumPartition("238182", 5));
        System.out.println(solution.minimumPartition("75734379996162298577", 7));
    }

    public int minimumPartition(String s, int k) {

        int digitsOfK = this.getDigitNumber(k);

        int[] dp = new int[s.length()];

        Arrays.fill(dp, -1);

        for (int i = 0; i < s.length(); i++) {
            if (i + 1 <= digitsOfK && Integer.parseInt(s.substring(0, i + 1)) <= k) {
                dp[i] = 1;
                continue;
            }
            int tmp = Integer.MAX_VALUE;
            // 从后向前遍历 k 位即可
            for (int j = i - 1; j >= Math.max(0, i - digitsOfK); j--) {
                // 这样一定能保证不超过位数
                if (dp[j] == -1 || Integer.parseInt(s.substring(j + 1, i + 1)) > k) {
                    // 不是好分隔
                    continue;
                }
                tmp = Math.min(tmp, dp[j] + 1);
            }
            if (tmp == Integer.MAX_VALUE) {
                continue;
            }
            if (dp[i] == -1) {
                dp[i] = tmp;
            } else {
                dp[i] = Math.min(dp[i], tmp);
            }
        }

        return dp[s.length() - 1];
    }

    private int getDigitNumber(int num) {
        int res = 0;
        while (num != 0) {
            res++;
            num /= 10;
        }
        return res;
    }
}

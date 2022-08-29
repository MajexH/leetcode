import java.util.Arrays;
import java.util.Scanner;

public class Vacation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] company = new int[n];
        int[] gym = new int[n];

        for (int i = 0; i < company.length; i++) {
            company[i] = sc.nextInt();
        }

        for (int i = 0; i < gym.length; i++) {
            gym[i] = sc.nextInt();
        }


        int[][] dp = new int[n + 1][3];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = dp[0][1] = dp[0][2] = 0;

        for (int i = 1; i <= n; i++) {

            // 如果当前状态是 休息 那么前一天可以是 工作 锻炼 休息
            dp[i][0] = 1 + Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2]));
            // 当前当前状态是 工作 那么前一天可以是 断连 or 休息
            if (company[i - 1] == 1) {
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
            }
            if (gym[i - 1] == 1) {
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }

        System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
    }
}

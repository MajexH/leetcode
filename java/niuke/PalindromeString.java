import java.util.Arrays;
import java.util.Scanner;

public class PalindromeString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        int[][] dp = new int[str.length()][str.length()];
        for (int i = str.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = j == i + 1 ? 2 : dp[i + 1][j - 1] + 2;
                } else {
                    // 如果收尾两项不等 则说明 最长的应该在中间
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
//        for (int i = 0; i < str.length(); i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(dp[0][str.length() - 1]);
    }
}

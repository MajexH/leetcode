import java.util.Arrays;
import java.util.Scanner;

public class BiShi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int[] dp = new int[input.length()];
        dp[0] = 1;
        for (int i = 1; i < input.length(); i++) {
            for (int j = 0; j <= 1; j++) {
                if (validNumber(input.substring(i - j, i + 1)))
                        dp[i] += i - j - 1 < 0 ? 1 :dp[i - j - 1];
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[input.length() - 1]);
    }

    public static boolean validNumber(String number) {
        if (number.length() > 1 && number.startsWith("0")) return false;
        // 假定输入时完全正确 除了数字 没有其它
        int temp = Integer.parseInt(number);
        return temp >= 1 && temp <= 26;
    }
}

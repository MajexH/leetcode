import java.util.Arrays;

public class TransferStr {

    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     *
     * @param num 需要翻译的数字
     * @return 能够形成的多少种的翻译方法
     */
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int[] dp = new int[numStr.length() + 1];
        dp[numStr.length()] = 1;
        for (int i = numStr.length() - 1; i >= 0; i--) {
            for (int j = i; j < Math.min(i + 2, numStr.length()); j++) {
                // 合法字符
                if (checkNumberStr(numStr, i, j)) {
                    dp[i] += dp[j + 1];
                }
            }
        }
        return dp[0];
    }

    // 这样写是为了效率 少调用几次 substring
    public boolean checkNumberStr(String num, int start, int end) {
        // 长度大于 1 却以 0 字符作为数字的开头是不能的
        if (end - start + 1 > 1 && num.charAt(start) == '0') return false;
        int temp = Integer.parseInt(num.substring(start, end + 1));
        return temp >= 0 && temp <= 25;
    }

    public static void main(String[] args) {
        System.out.println(new TransferStr().translateNum(506));
    }
}

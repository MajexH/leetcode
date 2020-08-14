package chapter5;

import java.util.ArrayList;
import java.util.List;

public class TranslateNumToStr_46 {

    // 数字翻译成字符串有几种方法
    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，
     * 1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        // dp[i] 表示以在 str 中以 i 开头的数字能够形成几个不同的翻译
        int[] dp = new int[str.length() + 1];
        dp[str.length()] = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            // 遍历两位数字
            for (int j = i + 1; j <= Math.min(i + 2, str.length()); j++) {
                if (canTranslate(str, i, j)) {
                    dp[i] += dp[j];
                }
            }
        }
        return dp[0];
    }

    // 翻译数字 得到他所有的翻译集合
    public List<String> translateNum(String num) {
        return recursion(num, 0);
    }

    // 可以加一个memo 因为有重复
    public List<String> recursion(String num, int index) {
        List<String> res = new ArrayList<>();
        if (index >= num.length()) {
            res.add("");
            return res;
        }
        for (int i = 1; i <= 2; i++) {
            if (index + i <= num.length() && canTranslate(num, index, index + i)) {
                for (String s :recursion(num, index + i)) {
                    res.add(translateNumToChar(num.substring(index, index + i)) + s);
                }
            }
        }
        return res;
    }

    public char translateNumToChar(String num) {
        return (char) (Integer.parseInt(num) + 'a');
    }

    public boolean canTranslate(String num, int i, int j) {
        if (j <= i) return false;
        if (i + 1 == j) return num.charAt(i) >= '0' && num.charAt(i) <= '9';
        // 只有两位数的情况了
        if (num.charAt(i) == '0') return false;
        int temp = Integer.parseInt(num.substring(i, j));
        return temp > 0 && temp < 26;
    }

    public static void main(String[] args) {
        System.out.println(new TranslateNumToStr_46().translateNum(12258));
        System.out.println(new TranslateNumToStr_46().translateNum("12258"));
    }
}

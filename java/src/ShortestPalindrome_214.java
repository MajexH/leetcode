import java.util.Arrays;

public class ShortestPalindrome_214 {

    public String shortestPalindrome(String s) {
        // 合并两个最长的 s
        // 以 # 分隔
        String reverse = new StringBuilder(s).reverse().toString();
        // 因为 s 要匹配的是 reverse 的后缀 所以把 reverse 加载后面
        String maxStr = s + "#" + reverse;
        // 这个时候最长的回文串长度保存在 next 最后一个胃
        int maxLength = getNext(maxStr);
        System.out.println(maxLength);
        return reverse.substring(0, reverse.length() - maxLength) + s;
    }

    private int getNext(String s) {
        int n = s.length();

        int[] next = new int[n + 1];
        next[0] = -1;
        // 让模式串错位一个开始 kmp 的匹配过程
        int k = -1, j = 0;
        while (j < n) {
            if (k == -1 || s.charAt(k) == s.charAt(j)) {
                k++;
                j++;
                next[j] = k;
            } else {
                // 根据已经匹配的长度 重新定位
                k = next[k];
            }
        }
        return next[n];
    }

    public static void main(String[] args) {
        System.out.println(new ShortestPalindrome_214().shortestPalindrome("aacecaaa"));
    }
}

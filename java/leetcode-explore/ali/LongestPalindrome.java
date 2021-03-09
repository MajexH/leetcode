package ali;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    // 给定一个字符串 根据这个字符串中的字符 构建一个最长的回文字符串 返回其长度
    // 他不是要连续的字符串 而是要随机选 不用连续
    public int longestPalindrome(String s) {
        // 要能够组成回文串 那么说明奇数个数的只能出现一个或者 0 个 其他的必须是偶数个数
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 既然是随便选字母 那么就
        // 偶数的随便选 奇数的 只需要减去 1 选取剩下的即可
        int res = 0;
        boolean hasOdd = false;
        for (int val : map.values()) {
            if ((val & 1) == 0) {
                // 偶数
                // 直接接上
                res += val;
            } else if (val > 1) {
                // 只选取其中的偶数部分
                res += val - 1;
                // 可以选取其中的 奇数部分
                hasOdd = true;
            } else {
                hasOdd = true;
            }
        }


        return hasOdd ? res + 1 : res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("bb"));
    }
}

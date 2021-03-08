package microsoft;

public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        // 如果反字符串的后面的字符 与 字符串 s 前面的字符相等
        // 说明 只需要加上这个 逆序的字符串 就可以构成的
        // 同时从后往前找 碰到的第一个位置 一定是最短的
        for (int i = s.length(); i >= 0; i--) {
            if (s.substring(0, i).equals(reverse.substring(s.length() - i))) {
                return reverse.substring(0, s.length() - i) + s;
            }
        }
        return "";
    }

    // 只能在字符串前面添加
    // 代码写的有点难看 ····
    // 遍历能够形成回文串的节点
    public String shortestPalindromeTravelAllSegment(String s) {
        if (s.equals("")) return "";
        String min = null;
        // 作为 palindrome 的中心点 进行遍历
        for (int i = 0; i <= s.length() / 2; i++) {
            String odd = odd(i, s);
            String even = even(i, s);
            String tmp = "";
            if (odd.equals("") && even.equals("")) {
                continue;
            }
            if (odd.equals("")) tmp = even;
            if (even.equals("")) tmp = odd;
            if (!odd.equals("") && !even.equals("")) {
                tmp = even.length() > odd.length() ? odd : even;
            }

            if (min == null) min = tmp;
            else if (min.length() > tmp.length()) {
                min = tmp;
            }
        }
        return min;
    }

    private String odd(int i, String s) {
        int left = i - 1, right = i + 1;
        // 考虑最后的 palindrome 是奇数长度情况
        boolean canPalindrome = true;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                // 不能形成
                canPalindrome = false;
                break;
            }
            left--;
            right++;
        }
        String tmp = "";
        if (!canPalindrome) return tmp;

        // 左边为 -1 说明右边长要把右边的加载左边
        if (left == -1) {
            StringBuilder builder = new StringBuilder(s.substring(right));

            tmp = builder.reverse().toString() + s;
        }
        return tmp;
    }

    private String even(int i, String s) {
        int left = i - 1, right = i;
        // 考虑最后的 palindrome 是奇数长度情况
        boolean canPalindrome = true;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                // 不能形成
                canPalindrome = false;
                break;
            }
            left--;
            right++;
        }
        String tmp = "";
        if (!canPalindrome) return tmp;

        // 左边为 -1 说明右边长要把右边的加载左边
        if (left == -1) {
            StringBuilder builder = new StringBuilder(s.substring(right));

            tmp = builder.reverse().toString() + s;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestPalindrome().shortestPalindrome("aacecaaa"));
        System.out.println(new ShortestPalindrome().shortestPalindrome("abcd"));
        System.out.println(new ShortestPalindrome().shortestPalindrome("abbacd"));
        System.out.println(new ShortestPalindrome().shortestPalindrome("abb"));
    }
}

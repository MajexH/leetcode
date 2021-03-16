public class ShortestPalindromeNew_214 {

    // keep 春招就考的这个
    public String shortestPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();

        String addedStr = s + "#" + reverse;

        int len = getMaxMatchLen(addedStr);

        return reverse.substring(0, reverse.length() - len) + s;
    }


    // 找到从末尾开始的前后缀的最长匹配长度
    public int getMaxMatchLen(String s) {
        int[] next = new int[s.length() + 1];
        next[0] = -1;
        int k = -1, j = 0;
        while (j < s.length()) {
            if (k == -1 || s.charAt(k) == s.charAt(j)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next[s.length()];
    }
}

public class ShortestPalindrome_New_214 {

    public String shortestPalindrome(String s) {
        String reverseStr = new StringBuffer(s).reverse().toString();
        // 找到 str 相同的前后缀长度
        String str = s + "#" + reverseStr;
        int len = getCommonStringLen(str);
        return reverseStr.substring(0, reverseStr.length() - len) + s;
    }

    public int getCommonStringLen(String str) {
        int[] next = new int[str.length() + 1];
        next[0] = -1;
        int k = -1, j = 0;

        while (j < str.length()) {
            if (k == -1 || str.charAt(k) == str.charAt(j)) {
                k++;
                j++;
                // k 是前缀的长度
                // j 是对应后缀的地方
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next[str.length()];
    }

    public static void main(String[] args) {
        System.out.println(new ShortestPalindromeNew_214().shortestPalindrome("aacecaaa"));
        System.out.println(new ShortestPalindrome_New_214().shortestPalindrome("aacecaaa"));
    }
}

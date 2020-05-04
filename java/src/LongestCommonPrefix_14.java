public class LongestCommonPrefix_14 {

    public String divideAndConquer(String[] strs, int start, int end) {
        if (start >= end) return strs[start];
        int mid = (start + end) / 2;
        String left = divideAndConquer(strs, start, mid);
        String right = divideAndConquer(strs, mid + 1, end);
        return commonStr(left, right);
    }

    public String commonStr(String str1, String str2) {
        int i = 0;
        while (i < str1.length() && i < str2.length()) {
            if (str1.charAt(i) != str2.charAt(i)) break;
            i++;
        }
        return str1.length() > str2.length() ? str1.substring(0, i) : str2.substring(0, i);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        return divideAndConquer(strs, 0, strs.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix_14().longestCommonPrefix(new String[]{ "flower","flow","flight" }));

    }

}

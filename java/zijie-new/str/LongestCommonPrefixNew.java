package str;

/**
 * @author majexh
 */
public class LongestCommonPrefixNew {

    public String divideAndConquer(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }
        int mid = (start + end) / 2;
        String left = divideAndConquer(strs, start, mid);
        String right = divideAndConquer(strs, mid + 1, end);
        return getCommonPrefix(left, right);
    }

    public String getCommonPrefix(String s1, String s2) {
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            i++;
        }
        return s1.substring(0, i);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        return divideAndConquer(strs, 0, strs.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefixNew().longestCommonPrefix(new String[]{ "flower","flow","flight" }));
    }
}

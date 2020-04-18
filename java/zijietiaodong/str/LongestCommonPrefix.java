package str;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        return divideAndConquer(strs, 0, strs.length - 1);
    }

    public String divideAndConquer(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }
        int mid = (start + end) / 2;
        String left = divideAndConquer(strs, start, mid);
        String right = divideAndConquer(strs, mid + 1, end);
        return getCommonPrefix(left, right);
    }

    public String getCommonPrefix(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                break;
            }
        }
        return a.substring(0, i);
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{ "flower","flow","flight" }));
    }
}

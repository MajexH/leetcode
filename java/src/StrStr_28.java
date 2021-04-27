public class StrStr_28 {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        int[] next = getNext(needle);
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    private int[] getNext(String needle) {
        int[] res = new int[needle.length()];
        res[0] = -1;
        int j = 0, k = -1;
        while (j < needle.length() - 1) {
            if (k == -1 || needle.charAt(j) == needle.charAt(k)) {
                j++;
                k++;
                res[j] = k;
            } else {
                k = res[k];
            }
        }
        return res;
    }
}

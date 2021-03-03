package tencent.strAndArray;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        return merge(strs, 0, strs.length - 1);
    }

    public String merge(String[] strs, int i, int j) {
        if (i > j) {
            return "";
        }
        if (i == j) {
            return strs[i];
        }
        int mid = (i + j) / 2;
        return getCommonStr(merge(strs, i, mid), merge(strs, mid + 1, j));
    }

    public String getCommonStr(String str1, String str2) {
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            i++;
            j++;
        }
        return str1.substring(0, i);
    }
}

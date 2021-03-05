package shopee;

import java.util.Arrays;

public class LongestSubStringWithoutDuplicates {

    public int lengthOfLongestSubstring(String s) {
        int[] preIndexes = new int[256];
        Arrays.fill(preIndexes, -1);
        int curLen = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int preIndex = preIndexes[c];
            // 这个时候直接 ++
            if (preIndex == -1 || i - preIndex > curLen) {
                curLen++;
            } else {
                // 这个时候出现了重复字符了
                curLen = i - preIndex;
            }
            preIndexes[c] = i;
            res = Math.max(res, curLen);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubStringWithoutDuplicates().lengthOfLongestSubstring("abcabcbb"));
    }
}

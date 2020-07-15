package highFrequency.list;

import java.util.Arrays;

public class LongestSubWithoutDuplicates {
    public int lengthOfLongestSubstring(String s) {
        // 保存上一个字母出现的index -1 表示不存在
        int[] preIndexes = new int[255];
        Arrays.fill(preIndexes, -1);
        int maxLength = 0, curLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int preIndex = preIndexes[s.charAt(i)];
            if (preIndex == -1 || i - preIndex > curLength) {
                curLength++;
            } else {
                // 说明这个字符已经出现过了 而且还在 curlength 上
                curLength = i - preIndex;
            }
            maxLength = Math.max(maxLength, curLength);
            preIndexes[s.charAt(i)] = i;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubWithoutDuplicates().lengthOfLongestSubstring("pwwkew"));
    }
}

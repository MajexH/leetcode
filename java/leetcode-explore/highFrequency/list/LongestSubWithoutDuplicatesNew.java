package highFrequency.list;

import java.util.Arrays;

public class LongestSubWithoutDuplicatesNew {

    public int lengthOfLongestSubstring(String s) {
        // 保存上一个字符的位置
        int[] preIndexes = new int[255];
        Arrays.fill(preIndexes, -1);
        int maxLength = Integer.MIN_VALUE;
        // 保存当前的长度
        int currentLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int preIndex = preIndexes[c];
            // 说明前面出现过
            if (preIndex != -1) {
                // 说明前一次出现在当前的 length 之外
                if (i - preIndex > currentLength) {
                    currentLength++;
                } else {
                    // 说明是在里面的要减少 currentLength 长度
                    currentLength = i - preIndex;
                }
            } else {
                // 没出现过 就要 ++
                currentLength++;
            }
            preIndexes[c] = i;
            maxLength = Math.max(maxLength, currentLength);
        }
        return Math.max(maxLength, currentLength);
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubWithoutDuplicatesNew().lengthOfLongestSubstring("pwwkew"));
    }

}

package str;

import java.util.Arrays;

public class LongestSubStrWithoutDuplicates {

    public int lengthOfLongestSubstring(String s) {
        int[] memo = new int[255];
        Arrays.fill(memo, -1);
        int maxLength = 0, currentLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            int preIndex = memo[character];
            // 如果之前的这个character还未出现过 或者 在当前的 length 之外
            if (preIndex == -1 || i - currentLength > preIndex) {
                currentLength++;
            } else {
                // 说明现在的长度已经城府
                currentLength = i - preIndex;
            }
            maxLength = Math.max(maxLength, currentLength);
            memo[character] = i;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubStrWithoutDuplicates().lengthOfLongestSubstring("pwwkew"));
    }
}

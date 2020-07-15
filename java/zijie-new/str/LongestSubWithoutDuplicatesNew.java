package str;

import java.util.Arrays;

public class LongestSubWithoutDuplicatesNew {

    public int lengthOfLongestSubstring(String s) {
        // 保存上一个字符出现的下标
        // -1 表示还未出现过
        int[] memo = new int[255];
        Arrays.fill(memo, -1);
        int maxLength = 0, curLength = 0;
        for (int i = 0; i < s.length(); i++) {
            // 说明这个字符之前已经出现过
            // 现在要看这个字符是否在当前的 length 外
            if (memo[s.charAt(i)] != -1) {
                int pre = memo[s.charAt(i)];
                if (i - pre <= curLength) {
                    // 说明在现在的 curLength 的长度下已经出现了重复
                    curLength = i - pre;
                } else {
                    curLength++;
                }
            } else {
                curLength++;
            }
            maxLength = Math.max(maxLength, curLength);
            memo[s.charAt(i)] = i;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubWithoutDuplicatesNew().lengthOfLongestSubstring("bbb"));
    }
}

package str;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonStrWithoutDuplicates {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int curLength = 0;
        Map<Character, Integer> memo = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int pre = memo.getOrDefault(c, -1);
            // 说明长度超过了
            if (pre == -1 || i - curLength > pre) {
                curLength++;
            } else {
                // 说明要更新了现在的长度了
                curLength = i - pre;
            }
            maxLength = Math.max(maxLength, curLength);
            memo.put(c, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonStrWithoutDuplicates().lengthOfLongestSubstring("abcabcbb"));
    }
}

package chapter5;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString_48 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLength = 0, curLength = 0;
        Map<Character, Integer> memo = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (memo.containsKey(s.charAt(i))) {
                int preIndex = memo.get(s.charAt(i));
                if (curLength >= i - preIndex) {
                    curLength = i - preIndex;
                } else {
                    curLength++;
                }
            } else {
                curLength++;
            }
            maxLength = Math.max(maxLength, curLength);
            memo.put(s.charAt(i), i);
        }
        return maxLength;
    }
}

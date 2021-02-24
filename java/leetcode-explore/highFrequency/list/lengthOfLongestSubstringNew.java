package highFrequency.list;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstringNew {
    // 无重复子串
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> memo = new HashMap<>();
        int maxLen = 0;
        int curLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int preIndex = memo.getOrDefault(s.charAt(i), -1);

            if (preIndex == -1 || i - curLen > preIndex) {
                curLen++;
            } else {
                // 长度缩短到上次的出现之后
                curLen = i - preIndex;
            }
            memo.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }
}

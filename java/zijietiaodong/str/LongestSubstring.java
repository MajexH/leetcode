package str;

import java.util.HashMap;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int longest = 0;
        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (!map.containsKey(character)) {
               current++;
            } else {
                int pre = map.get(character);
                if (i - pre > current) {
                    current++;
                } else {
                    current = i - pre;
                }
            }
            longest = Math.max(longest, current);
            map.put(character, i);
        }
        return longest;
    }
}

package chapter5;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar_50 {

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) return c;
        }
        return ' ';
    }
}

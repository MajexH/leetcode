package str;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author majexh
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if (s1Map.containsKey(s1.charAt(i))) {
                s1Map.put(s1.charAt(i), s1Map.get(s1.charAt(i)) + 1);
            } else {
                s1Map.put(s1.charAt(i), 1);
            }

            if (s2Map.containsKey(s2.charAt(i))) {
                s2Map.put(s2.charAt(i), s2Map.get(s2.charAt(i)) + 1);
            } else {
                s2Map.put(s2.charAt(i), 1);
            }
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (checkMap(s1Map, s2Map)) {
                return true;
            }
            s2Map.put(s2.charAt(i), s2Map.get(s2.charAt(i)) - 1);

            char key = s2.charAt(i + s1.length());
            if (s2Map.containsKey(key)) {
                s2Map.put(key, s2Map.get(key) + 1);
            } else {
                s2Map.put(key, 1);
            }
        }
        return checkMap(s1Map, s2Map);
    }

    public boolean checkMap(HashMap<Character, Integer> s1Map, HashMap<Character, Integer> s2Map) {
        for (Character key : s1Map.keySet()) {
            if (!s2Map.containsKey(key) || !s2Map.get(key).equals(s1Map.get(key))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CheckInclusion().checkInclusion("ab", "eidboaooo"));
    }
}

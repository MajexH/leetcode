package highFrequency.classic;

import java.util.HashMap;

public class MinCoverStr {

    // 返回true 说明里面已经包含了一个完整的 t 字符串
    public boolean checkMap(HashMap<Character, Integer> mapForT, HashMap<Character, Integer> mapForS) {
        for (Character key : mapForT.keySet()) {
            if (!mapForS.containsKey(key) || mapForS.get(key) < mapForT.get(key)) return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        // 这都是不存在的
        if (s == null || t == null || s.length() < t.length()) return "";
        String minStr = null;
        HashMap<Character, Integer> mapForT = new HashMap<>();
        for (char character : t.toCharArray()) {
            if (!mapForT.containsKey(character)) {
                mapForT.put(character, 1);
            } else {
                mapForT.put(character, mapForT.get(character) + 1);
            }
        }

        HashMap<Character, Integer> mapForS = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character character = s.charAt(i);
            if (!mapForS.containsKey(character)) {
                mapForS.put(character, 1);
            } else {
                mapForS.put(character, mapForS.get(character) + 1);
            }
        }
        // 滑动窗口大小
        int left  = 0, right = t.length() - 1;
        do {
            while (checkMap(mapForT, mapForS) && right - left + 1 >= t.length()) {
                if (minStr == null || minStr.length() > right - left + 1) {
                    minStr = s.substring(left, right + 1);
                }
                mapForS.put(s.charAt(left), mapForS.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
            if (right >= s.length()) continue;
            if (!mapForS.containsKey(s.charAt(right))) {
                mapForS.put(s.charAt(right), 1);
            } else {
                mapForS.put(s.charAt(right), mapForS.get(s.charAt(right)) + 1);
            }
        } while (right <= s.length() - 1 && right - left + 1 > t.length());
        return minStr == null ? "" : minStr;
    }

    public static void main(String[] args) {
        System.out.println(new MinCoverStr().minWindow("ADOBECODEBANC", "ABC"));
    }
}

package highFrequency.str;

import java.util.*;
import java.util.stream.Collectors;

public class MostCommonWord {

    public boolean isAlpha(char character) {
        return (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z');
    }

    public List<String> splitString(String str) {
        List<String> res = new ArrayList<>();
        int pre = -1, i = 0;
        while (i < str.length()) {
            if (isAlpha(str.charAt(i))) {
                i++;
                continue;
            }
            if (pre + 1 == i) {
                pre++;
                i++;
                continue;
            }
            res.add(str.substring(pre + 1, i));
            pre = i;
            i++;
        }
        // 加入最后一个
        if (pre != i - 1)
            res.add(str.substring(pre + 1, i));
        return res;
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || banned == null || paragraph.length() == 0) return "";
        Set<String> bannedSet = Arrays.stream(banned).collect(Collectors.toSet());
        Map<String, Integer> map = new HashMap<>();
        for (String word : splitString(paragraph)) {
            // 跳过标点符号
            if (word.length() == 1 && !isAlpha(word.charAt(0))) continue;
            String lowerCase = word.toLowerCase();
            if (map.containsKey(lowerCase)) {
                map.put(lowerCase, map.get(lowerCase) + 1);
            } else {
                map.put(lowerCase, 1);
            }
        }
        System.out.println(map);
        System.out.println(bannedSet);
        int max = Integer.MIN_VALUE;
        String res = "";
        for (String key : map.keySet()) {
            if (!bannedSet.contains(key) && map.get(key) > max) {
                res = key;
                max = map.get(key);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MostCommonWord().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{ "hit" }));
        // System.out.println(new MostCommonWord().splitString("Bob hit a ball, the hit BALL flew far after it was hit."));
    }
}

package highFrequency.str;

import java.util.*;
import java.util.function.Supplier;

public class MostCommonWordNew {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = Arrays.stream(banned).collect((Supplier<Set<String>>) HashSet::new, (a, b) -> {
            a.add(b.toLowerCase());
        }, Set::addAll);
        Map<String, Integer> map = new HashMap<>();
        int maxAppear = 0;

        for (String tmp : splitStr(paragraph)) {
            tmp = tmp.toLowerCase();
            if (set.contains(tmp)) {
                continue;
            }
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            maxAppear = Math.max(maxAppear, map.get(tmp));
        }

        for (String key : map.keySet()) {
            if (map.get(key) == maxAppear) {
                return key;
            }
        }
        return "";
    }

    public List<String> splitStr(String origin) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        for (char c : origin.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                builder.append(c);
                continue;
            }
            if (builder.length() > 0) {
                res.add(builder.toString());
                builder.delete(0, builder.length());
            }
        }
        if (builder.length() > 0) res.add(builder.toString());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MostCommonWordNew().mostCommonWord("Bob", new String[]{"hit"}));
    }
}

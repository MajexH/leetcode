package highFrequency.hash;

import java.util.*;

public class GroupAnagramsNew {

    private int getHashCodeOfStr(String s) {
        int[] hash = new int[26];

        for (char c : s.toCharArray()) {
            // s 中均为小写字母
            hash[c - 'a']++;
        }

        return Arrays.hashCode(hash);
    }

    // 把相同的字符同分位加入
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int hash = getHashCodeOfStr(str);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagramsNew().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}

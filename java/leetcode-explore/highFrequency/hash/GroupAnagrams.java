package highFrequency.hash;

import java.util.*;

public class GroupAnagrams {

    public static class Key {
        int[] val;

        public Key(int[] val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            return Arrays.equals(val, key.val);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(val);
        }
    }

    /**
     *   字母异位词分组
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Key, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            Key key = new Key(getMemo(str));
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public int[] getMemo(String str) {
        int[] memo = new int[26];
        for (char c : str.toCharArray()) {
            memo[c - 'a']++;
        }
        return memo;
    }
    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{ "eat", "tea", "tan", "ate", "nat", "bat" }));
    }
}

import java.util.*;

public class GroupAnagrams_10_02 {

    private static class Wrapper {
        int[] data;

        public Wrapper(int[] data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Wrapper wrapper = (Wrapper) o;
            return Arrays.equals(data, wrapper.data);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(data);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Wrapper, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Wrapper wrapper = new Wrapper(getArray(str));
            if (!map.containsKey(wrapper)) map.put(wrapper, new ArrayList<>());
            map.get(wrapper).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private int[] getArray(String str) {
        int[] ints = new int[26];
        for (char c : str.toCharArray()) {
            ints[c - 'a']++;
        }
        return ints;
    }
}

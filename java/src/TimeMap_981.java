import java.util.*;

public class TimeMap_981 {

    private static class Pair implements Comparable<Pair> {
        String value;
        int timeStamp;

        public Pair(String value, int timeStamp) {
            this.value = value;
            this.timeStamp = timeStamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return timeStamp == pair.timeStamp && Objects.equals(value, pair.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, timeStamp);
        }

        @Override
        public int compareTo(Pair o) {
            return timeStamp - o.timeStamp;
        }
    }

    private Map<String, TreeSet<Pair>> map;

    /** Initialize your data structure here. */
    public TimeMap_981() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new TreeSet<>());
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        TreeSet<Pair> tmp = map.get(key);
        // 获取小于等于 timeStamp 的最大值
        Pair res = tmp.floor(new Pair("", timestamp));
        if (res == null) return "";
        return res.value;
    }

    public static void main(String[] args) {
        TimeMap_981 tmp = new TimeMap_981();
        tmp.set("foo", "bar", 1);
        System.out.println(tmp.get("foo", 1));
        System.out.println(tmp.get("foo", 3));
        tmp.set("foo", "bar2", 4);
        System.out.println(tmp.get("foo", 4));
        System.out.println(tmp.get("foo", 5));
    }
}

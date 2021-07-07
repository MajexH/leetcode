import java.util.*;

public class CountPairs_1711 {

    // 由于数组比较长 而只需要遍历 2 的幂次方
    // 同时数字最大 2 ^ 20 所以 遍历 和 的话 只需要 遍历 20 次
    public int countPairs(int[] deliciousness) {
        if (deliciousness.length == 0) return 0;
        int max = Arrays.stream(deliciousness).max().getAsInt();
        long res = 0L;
        Map<Integer, Integer> map = new HashMap<>();

        for (int delicious : deliciousness) {
            // 遍历 sum sum 最大为 两个 max 相加 每次 sum 扩大为下一个 2 的幂次方
            for (int sum = 1; sum <= max * 2; sum <<= 1) {
                if (!map.containsKey(sum - delicious)) continue;
                res = (res + map.get(sum - delicious)) % 1000000007;
            }
            // 这样相当于遍历之前的数字 看已经遍历过的 是否可以组成
            map.put(delicious, map.getOrDefault(delicious, 0) + 1);
        }
        // 除 2 是因为算了两边 遍历 1 的时候 已经跟 3 组合了 然后遍历 3 的时候 又跟 1 组合了一次
        return (int) res;
    }

    private static class Pair {
        int counter, num;

        public Pair(int counter, int num) {
            this.counter = counter;
            this.num = num;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return num == pair.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num);
        }
    }

    public int countPairsWithCompress(int[] deliciousness) {
        long res = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int delicious : deliciousness) {
            map.put(delicious, map.getOrDefault(delicious, 0) + 1);
        }

        List<Pair> pairList = new ArrayList<>();

        for (Integer key : map.keySet()) {
            pairList.add(new Pair(map.get(key), key));
        }

        for (int i = 0; i < pairList.size(); i++) {
            Pair a = pairList.get(i);
            if (a.num > 0 && isPowOfTwo(a.num) && a.counter > 1) {
                res = (res + ((long) a.counter * (a.counter - 1)) / 2) % 1000000007;
            }
            for (int j = i + 1; j < pairList.size(); j++) {
                Pair b = pairList.get(j);
                if (!isPowOfTwo(a.num + b.num)) continue;
                res = (res + (long) a.counter * b.counter) % 1000000007;
            }
        }

        return (int) (res % 1000000007);
    }

    private boolean isPowOfTwo(int num) {
        return (num & (num - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new CountPairs_1711().countPairs(new int[]{2160,1936,3,29,27,5,2503,1593,2,0,16,0,3860,28908,6,2,15,49,6246,1946,23,105,7996,196,0,2,55,457,5,3,924,7268,16,48,4,0,12,116,2628,1468}));
    }
}

package algorithmInterview.hash;

import java.util.HashMap;
import java.util.Map;

public class FourSumTwo {

    public Map<Integer, Integer> getMap(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int k : A) {
            for (int i : B) {
                map.put(k + i, map.getOrDefault(k + i, 0) + 1);
            }
        }
        return map;
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map1 = getMap(A, B);
        Map<Integer, Integer> map2 = getMap(C, D);

        int res = 0;
        for (Integer key : map1.keySet()) {
            if (map2.containsKey(-key)) {
                res += map1.get(key) * map2.get(-key);
            }
        }
        return res;
    }
}

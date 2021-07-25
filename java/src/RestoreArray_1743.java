import java.util.*;

public class RestoreArray_1743 {

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] adjacent : adjacentPairs) {
            int a = adjacent[0], b = adjacent[1];
            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            map.get(a).add(b);
            if (a == b) continue;
            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            map.get(b).add(a);
        }

        // 度数为 1
        int start = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }

        List<Integer> res = new ArrayList<>();
        Set<Integer> memo = new HashSet<>();
        do {
            res.add(start);
            memo.add(start);
            List<Integer> tmp = map.get(start);
            for (int num : tmp) {
                if (!memo.contains(num)) {
                    start = num;
                    break;
                }
            }
        } while (map.get(start).size() != 1);
        res.add(start);
        int[] array = new int[res.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = res.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RestoreArray_1743().restoreArray(new int[][]{
                {2, 1}, {3, 4}, {3, 2}
        })));
        System.out.println(Arrays.toString(new RestoreArray_1743().restoreArray(new int[][]{
                {4,-2}, {1, 4}, {-3, 1}
        })));
    }
}

import java.util.*;

public class NumWays_LCP07 {

    // 有环的话 就不行
    // 如果在 环上的话 而且 没有 n - 1 的话 说明就不可能达到
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int res = 0;
        for (int[] r : relation) {
            if (!map.containsKey(r[0])) {
                map.put(r[0], new ArrayList<>());
            }
            map.get(r[0]).add(r[1]);
        }

        Deque<Integer> queue = new LinkedList<>();
        Deque<Integer> counter = new LinkedList<>();

        queue.add(0);
        counter.add(0);
        while (!queue.isEmpty()) {
            int top = queue.removeFirst();
            int count = counter.removeFirst();
            // 如果比 k 到 说明已经不可能在 k 步内走到了
            if (count >= k) continue;
            for (int adj : map.getOrDefault(top, new ArrayList<>())) {
                if (adj == n - 1 && count + 1 == k) {
                    res++;
                    continue;
                }
                queue.add(adj);
                counter.add(count + 1);
            }
        }
        return res;
    }


}

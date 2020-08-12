package algorithmInterview.heapAndStackAndQueue;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class KTopFrequencyElement {

    class Pair {
        public int num;
        public int counter;

        public Pair(int num, int counter) {
            this.num = num;
            this.counter = counter;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null) return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 小顶堆
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.counter));

        for (Integer key : map.keySet()) {
            queue.add(new Pair(key, map.get(key)));
            if (queue.size() > k) queue.poll();
        }
        int[] res = new int[queue.size()];
        int i = 0;
        for (Pair p : queue) {
            res[i++] = p.num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new KTopFrequencyElement().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}

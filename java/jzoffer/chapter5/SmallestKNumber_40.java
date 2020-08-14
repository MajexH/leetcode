package chapter5;

import java.util.PriorityQueue;

public class SmallestKNumber_40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        // 大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : arr) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            assert !queue.isEmpty();
            res[i] = queue.poll();
        }
        return res;
    }
}

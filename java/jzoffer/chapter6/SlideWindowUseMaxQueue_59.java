package chapter6;

import java.util.ArrayList;
import java.util.List;

public class SlideWindowUseMaxQueue_59 {

    private MaxQueue_59 queue = new MaxQueue_59();

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            queue.addLast(num);
            if (queue.size() > k) queue.removeFirst();
            if (queue.size() == k) res.add(queue.max());
        }
        int[] ints = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ints[i] = res.get(i);
        }
        return ints;
    }
}

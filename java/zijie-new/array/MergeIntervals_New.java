package array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MergeIntervals_New {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        Deque<int[]> stack = new LinkedList<>();

        for (int[] interval : intervals) {
            if (stack.size() == 0) {
                stack.add(interval);
            } else {
                int[] last = stack.peekLast();
                if (last[1] < interval[0]) {
                    stack.add(interval);
                } else {
                    stack.removeLast();
                    stack.add(new int[]{last[0], Math.max(last[1], interval[1])});
                }
            }
        }
        int[][] res = new int[stack.size()][];

        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}

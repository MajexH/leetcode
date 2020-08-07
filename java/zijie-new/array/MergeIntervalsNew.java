package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class MergeIntervalsNew {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Deque<int[]> stack = new LinkedList<>();
        for (int[] interval : intervals) {
            if (stack.size() == 0) {
                stack.push(interval);
            } else {
                int[] top = stack.peek();
                if (top[1] >= interval[0]) {
                    stack.pop();
                    stack.push(new int[]{ top[0], Math.max(interval[1], top[1]) });
                } else {
                    stack.push(interval);
                }
            }
        }
        return stack.toArray(new int[0][]);
    }
}

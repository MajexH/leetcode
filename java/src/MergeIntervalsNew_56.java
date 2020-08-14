import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MergeIntervalsNew_56 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            else
                return a[1] - b[1];
        });
        Deque<int[]> stack = new LinkedList<>();
        for (int[] interval : intervals) {
            if (stack.size() == 0) {
                stack.addLast(interval);
            } else {
                int[] top = stack.peekLast();
                if (top[1] < interval[0]) {
                    stack.addLast(interval);
                } else {
                    stack.pollLast();
                    stack.add(new int[]{ top[0], Math.max(top[1], interval[1]) });
                }
            }
        }
        int[][] res = new int[stack.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pollFirst();
        }
        return res;
    }
}

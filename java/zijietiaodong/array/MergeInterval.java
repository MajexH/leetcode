package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> stack = new LinkedList<>();
        stack.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] top = stack.peekLast();
            int[] cur = intervals[i];
            assert top != null;
            if (top[1] >= cur[0]) {
                stack.removeLast();
                stack.add(new int[]{ top[0], Math.max(top[1], cur[1]) });
            } else {
                stack.add(cur);
            }
        }
        int[][] res = new int[stack.size()][];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new MergeInterval().merge(new int[][]{
                {1, 3}, {2, 6}, {15, 18}, {8, 10}
        })));
    }
}

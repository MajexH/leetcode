package MergeIntervals56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] pre = list.get(list.size() - 1);
            int[] current = intervals[i];

            if (pre[1] >= current[0]) {
                list.remove(list.size() - 1);
                list.add(new int[]{ pre[0], Math.max(pre[1], current[1])});
            } else {
                list.add(current);
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{ {1,3},{8,10},{2,6},{15,18}};
        System.out.println(Arrays.deepToString(new Solution().merge(intervals)));
    }
}

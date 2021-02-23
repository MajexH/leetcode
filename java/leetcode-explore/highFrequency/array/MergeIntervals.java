package highFrequency.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.size() == 0) {
                merged.add(interval);
                continue;
            }
            int[] top = merged.get(merged.size() - 1);

            if (top[1] < interval[0]) {
                merged.add(interval);
                continue;
            }
            merged.remove(merged.size() - 1);
            merged.add(new int[]{Math.min(top[0], interval[0]), Math.max(top[1], interval[1])});
        }

        int[][] returnVal = new int[merged.size()][];

        for (int i = 0; i < merged.size(); i++) {
            returnVal[i] = merged.get(i);
        }
        return returnVal;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}

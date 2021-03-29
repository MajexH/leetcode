import java.util.Arrays;
import java.util.TreeSet;

public class FindRightInterval_436 {

    private static class Pair implements Comparable<Pair> {
        int start;
        int index;

        public Pair(int start, int index) {
            this.start = start;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return start - o.start;
        }
    }

    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        TreeSet<Pair> tree = new TreeSet<>();

        for (int i = 0; i < res.length; i++) {
            tree.add(new Pair(intervals[i][0], i));
        }

        for (int i = 0; i < res.length; i++) {
            int end = intervals[i][1];

            Pair p = tree.ceiling(new Pair(end, i));
            if (p == null) res[i] = -1;
            else res[i] = p.index;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindRightInterval_436().findRightInterval(new int[][]{
                {1, 2}
        })));
        System.out.println(Arrays.toString(new FindRightInterval_436().findRightInterval(new int[][]{
                {3, 4},
                {2, 3},
                {1, 2}
        })));
        System.out.println(Arrays.toString(new FindRightInterval_436().findRightInterval(new int[][]{
                {1, 4},
                {2, 3},
                {3, 4}
        })));
    }
}

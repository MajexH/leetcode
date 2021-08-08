import java.util.ArrayList;
import java.util.List;

public class KWeakestRows_1337 {

    private static class Pair {
        int counter;
        int index;

        public Pair(int counter, int index) {
            this.counter = counter;
            this.index = index;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {

        List<Pair> tmp = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            tmp.add(new Pair(getCounter(mat[i]), i));
        }

        tmp.sort((a, b) -> {
            if (a.counter == b.counter) {
                return a.index - b.index;
            }
            return a.counter - b.counter;
        });

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = tmp.get(i).index;
        }
        return res;
    }

    private static int getCounter(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return res;
    }
}

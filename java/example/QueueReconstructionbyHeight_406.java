import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionbyHeight_406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else
                return b[0] - a[0];
        });
        List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        int[][] returnRes = new int[people.length][];
        for (int i = 0; i < res.size(); i++) {
            returnRes[i] = res.get(i);
        }
        return returnRes;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new QueueReconstructionbyHeight_406().reconstructQueue(new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        })));
    }
}

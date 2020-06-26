package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author majexh
 */
public class TrianglePathSumNew {

    public int recursion(List<List<Integer>> triangle, int i, int j, int[][] memo) {
        // 越界
        if (i < 0 || i >= triangle.size() || j < 0 || j >= triangle.get(i).size()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        memo[i][j] = triangle.get(i).get(j) + Math.min(recursion(triangle, i + 1, j, memo), recursion(triangle, i + 1, j + 1, memo));
        return memo[i][j];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()][];
        for (int i = 0; i < triangle.size(); i++) {
            memo[i] = new int[triangle.get(i).size()];
            Arrays.fill(memo[i], -1);
        }

        return recursion(triangle, 0, 0, memo);
    }

    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<>();

        test.add(new ArrayList<>(){{
            add(2);
        }});
        test.add(new ArrayList<>(){{
            add(3);
            add(4);
        }});
        test.add(new ArrayList<>(){{
            add(6);
            add(5);
            add(7);
        }});
        test.add(new ArrayList<>(){{
            add(4);
            add(1);
            add(8);
            add(3);
        }});
        System.out.println(new TrianglePathSumNew().minimumTotal(test));
    }
}

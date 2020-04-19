package array;

import java.util.LinkedList;

public class Friends {

    public int dfs(int[][] M, boolean[] memo, int i) {
        memo[i] = true;
        for (int index = 0; index < M[i].length; index++) {
            if (M[i][index] == 1 && !memo[index]) {
                dfs(M, memo, index);
            }
        }
        return 1;
    }

    public int findCircleNum(int[][] M) {
        int res = 0;
        boolean[] memo = new boolean[M.length];

        for (int i = 0; i < M.length; i++) {
            if (!memo[i])
                res += dfs(M, memo, i);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Friends().findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        }));
    }
}

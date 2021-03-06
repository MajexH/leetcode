package tencent.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
        boolean[][] marked = new boolean[matrix.length][];
        // 记忆优化 从底向上返回
        int[][] memo = new int[matrix.length][];
        for (int i = 0; i < marked.length; i++) {
            marked[i] = new boolean[matrix[i].length];
            memo[i] = new int[matrix[i].length];
            Arrays.fill(memo[i], -1);
        }
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // 如果已经在一个之前访问过的最长路径上
                // 是不可能从 之前的路径上找到另外一条最长路径的
                if (!marked[i][j]) {
                    res = Math.max(res, dfs(matrix, memo, marked, i, j));
                }
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int[][] memo, boolean[][] marked, int i, int j) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 0;
        marked[i][j] = true;
        // 比较后面的返回来的最长长度
        if (i + 1 < matrix.length && !marked[i + 1][j] && matrix[i + 1][j] > matrix[i][j]) {
            res = Math.max(res, dfs(matrix, memo, marked, i + 1, j));
        }
        if (i - 1 >= 0 && !marked[i - 1][j] && matrix[i - 1][j] > matrix[i][j]) {
            res = Math.max(res, dfs(matrix, memo, marked, i - 1, j));
        }
        if (j + 1 < matrix[i].length && !marked[i][j + 1] && matrix[i][j + 1] > matrix[i][j]) {
            res = Math.max(res, dfs(matrix, memo, marked, i, j + 1));
        }
        if (j - 1 >= 0 && !marked[i][j - 1] && matrix[i][j - 1] > matrix[i][j]) {
            res = Math.max(res, dfs(matrix, memo, marked, i, j - 1));
        }
        // 机上当前这个节点的长度
        memo[i][j] = res + 1;
        marked[i][j] = false;
        return memo[i][j];
    }

    // 这个方法采用的是直接 dfs
    // dfs 是把结果传递到最后的节点上 再比较
    // 导致的结果是 这样会循环很多次 超时
    public int longestIncreasingPathRaw(int[][] matrix) {
        boolean[][] memo = new boolean[matrix.length][];
        boolean[][] marked = new boolean[matrix.length][];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = new boolean[matrix[i].length];
            marked[i] = new boolean[matrix[i].length];
        }
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // 如果已经在一个之前访问过的最长路径上
                // 是不可能从 之前的路径上找到另外一条最长路径的
                if (!memo[i][j]) {
                    List<Pair> tmp = new ArrayList<>();
                    dfsWithoutMemo(matrix, i, j, new ArrayList<>(), tmp, marked);
                    for (Pair t : tmp) {
                        memo[t.x][t.y] = true;
                    }
                    res = Math.max(res, tmp.size());
                }
            }
        }
        return res;
    }

    private static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // memo 用来表示整体的 marked 用来在单次访问中避免成环访问
    public void dfsWithoutMemo(int[][] matrix, int i, int j, List<Pair> paths, List<Pair> res, boolean[][] marked) {
        paths.add(new Pair(i, j));
        if (paths.size() > res.size()) {
            res.clear();
            res.addAll(paths);
        }
        marked[i][j] = true;
        if (i + 1 < matrix.length && !marked[i + 1][j] && matrix[i + 1][j] > matrix[i][j]) {
            dfsWithoutMemo(matrix, i + 1, j, paths, res, marked);
        }
        if (i - 1 >= 0 && !marked[i - 1][j] && matrix[i - 1][j] > matrix[i][j]) {
            dfsWithoutMemo(matrix, i - 1, j, paths, res, marked);
        }
        if (j + 1 < matrix[i].length && !marked[i][j + 1] && matrix[i][j + 1] > matrix[i][j]) {
            dfsWithoutMemo(matrix, i, j + 1, paths, res, marked);
        }
        if (j - 1 >= 0 && !marked[i][j - 1] && matrix[i][j - 1] > matrix[i][j]) {
            dfsWithoutMemo(matrix, i, j - 1, paths, res, marked);
        }
        paths.remove(paths.size() - 1);
        marked[i][j] = false;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingPath().longestIncreasingPath(new int[][]{
                {1}
        }));
        System.out.println(new LongestIncreasingPath().longestIncreasingPath(new int[][]{
                {3,4,5},{3,2,6},{2,2,1}
        }));
        System.out.println(new LongestIncreasingPath().longestIncreasingPath(new int[][]{
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                {19, 18, 17, 16, 15, 14, 13, 12, 11, 10},
                {20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
                {39, 38, 37, 36, 35, 34, 33, 32, 31, 30},
                {40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
                {59, 58, 57, 56, 55, 54, 53, 52, 51, 50},
                {60, 61, 62, 63, 64, 65, 66, 67, 68, 69},
                {79, 78, 77, 76, 75, 74, 73, 72, 71, 70},
                {80, 81, 82, 83, 84, 85, 86, 87, 88, 89},
                {99, 98, 97, 96, 95, 94, 93, 92, 91, 90},
                {100, 101, 102, 103, 104, 105, 106, 107, 108, 109},
                {119, 118, 117, 116, 115, 114, 113, 112, 111, 110},
                {120, 121, 122, 123, 124, 125, 126, 127, 128, 129},
                {139, 138, 137, 136, 135, 134, 133, 132, 131, 130},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        }));
    }
}

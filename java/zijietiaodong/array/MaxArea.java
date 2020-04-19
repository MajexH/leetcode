package array;

import java.util.LinkedList;

public class MaxArea {

    public class Pair {
        public int i;
        public int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    public int dfs(boolean[][] memo, int[][] grid, int i, int j) {
        LinkedList<Pair> stack = new LinkedList<>();
        stack.add(new Pair(i, j));
        memo[i][j] = true;
        int res = 0;
        while (stack.size() != 0) {
            Pair top = stack.removeLast();
            res++;
            if (top.i - 1 >= 0 && !memo[top.i - 1][top.j] && grid[top.i - 1][top.j] == 1) {
                stack.add(new Pair(top.i - 1, top.j));
                memo[top.i - 1][top.j] = true;
            }
            if (top.i + 1 < grid.length && !memo[top.i + 1][top.j] && grid[top.i + 1][top.j] == 1) {
                stack.add(new Pair(top.i + 1, top.j));
                memo[top.i + 1][top.j] = true;
            }
            if (top.j - 1 >= 0 && !memo[top.i][top.j - 1] && grid[top.i][top.j - 1] == 1) {
                stack.add(new Pair(top.i, top.j - 1));
                memo[top.i][top.j - 1] = true;
            }
            if (top.j + 1 < grid[top.i].length && !memo[top.i][top.j + 1] && grid[top.i][top.j + 1] == 1) {
                stack.add(new Pair(top.i, top.j + 1));
                memo[top.i][top.j + 1] = true;
            }
        }
        return res;
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] memo = new boolean[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            memo[i] = new boolean[grid[i].length];
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !memo[i][j]) {
                    res = Math.max(res, dfs(memo, grid, i, j));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };
        System.out.println(new MaxArea().maxAreaOfIsland(grid));
    }
}

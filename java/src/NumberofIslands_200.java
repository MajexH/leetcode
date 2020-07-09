public class NumberofIslands_200 {

    public void dfs(char[][] grid, boolean[][] memo, int i, int j) {
        memo[i][j] = true;

        if (i + 1 < grid.length && grid[i + 1][j] == '1' && !memo[i + 1][j]) {
            dfs(grid, memo, i + 1, j);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1' && !memo[i - 1][j]) {
            dfs(grid, memo, i - 1, j);
        }
        if (j + 1 < grid[i].length && grid[i][j + 1] == '1' && !memo[i][j + 1]) {
            dfs(grid, memo, i, j + 1);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1' && !memo[i][j - 1]) {
            dfs(grid, memo, i, j - 1);
        }
    }

    public int numIslands(char[][] grid) {
        boolean[][] memo = new boolean[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            memo[i] = new boolean[grid[i].length];
        }
        int res = 0;
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                if (grid[i][j] == '1' && !memo[i][j]) {
                    dfs(grid, memo, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumberofIslands_200().numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','1'},
                {'0','0','0','1','0'}
        }));
    }
}

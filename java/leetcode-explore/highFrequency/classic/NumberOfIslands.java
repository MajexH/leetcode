package highFrequency.classic;

public class NumberOfIslands {

    public void dfs(char[][] grid, boolean[][] memo, int start, int end) {
        memo[start][end] = true;
        if (start + 1 < grid.length && grid[start + 1][end] == '1' && !memo[start + 1][end])
            dfs(grid, memo, start + 1, end);
        if (start - 1 >= 0 && grid[start - 1][end] == '1' && !memo[start - 1][end])
            dfs(grid, memo, start - 1, end);
        if (end + 1 < grid[start].length && grid[start][end + 1] == '1' && !memo[start][end + 1])
            dfs(grid, memo, start, end + 1);
        if (end - 1 >= 0 && grid[start][end - 1] == '1' && !memo[start][end - 1])
            dfs(grid, memo, start, end - 1);
    }

    public int numIslands(char[][] grid) {
        int res = 0;

        boolean[][] memo = new boolean[grid.length][];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = new boolean[grid[i].length];
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!memo[i][j] && grid[i][j] == '1') {
                    dfs(grid, memo, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfIslands().numIslands(new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        }));
    }
}

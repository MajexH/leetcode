package chapter2;

public class Exist_12 {

    // 判断一个 word 是否出现在二维矩阵中
    public boolean exist(char[][] board, String word) {
        boolean[][] memo = new boolean[board.length][];
        for (int i = 0; i < board.length; i++) {
            memo[i] = new boolean[board[i].length];
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, memo, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] memo, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) return false;
        if (word.charAt(index) != board[i][j]) return false;
        if (memo[i][j]) return false;
        memo[i][j] = true;
        boolean res = dfs(board, memo, i + 1, j, word, index + 1) ||
                dfs(board, memo, i - 1, j, word, index + 1) ||
                dfs(board, memo, i, j + 1, word, index + 1) ||
                dfs(board, memo, i, j - 1, word, index + 1);
        memo[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Exist_12().exist(new char[][]{{'a'}}, "ab"));
    }
}

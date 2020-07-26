package highFrequency.backTrack;

import java.util.Arrays;

public class SearchWord {

    public boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] memo) {
        // 这个表示 word 已经匹配完毕
        if (index >= word.length()) return true;
        // 越界或者对不上号
        if (i >= board.length || i < 0 || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index))
            return false;
        // 已经访问过了
        if (memo[i][j]) return false;
        memo[i][j] = true;

        boolean flag = dfs(board, word, index + 1, i + 1, j, memo) ||
                        dfs(board, word, index + 1, i - 1, j, memo) ||
                        dfs(board, word, index + 1, i, j + 1, memo) ||
                        dfs(board, word, index + 1, i, j - 1, memo);
        if (!flag)  // 这次匹配失败 需要把 memo 这个点充值
            memo[i][j] = false;
        return flag;
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] memo = new boolean[board.length][];
        for (int i = 0; i < board.length; i++) {
            memo[i] = new boolean[board[i].length];
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, 0, i, j, memo)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SearchWord().exist(new char[][]{
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        }, "AAB"));
    }
}

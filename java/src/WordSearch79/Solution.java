package WordSearch79;

public class Solution {

    public boolean exist(char[][] board, String word) {
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 找到起始位置 然后dfs
                if (board[i][j] == word.charAt(0)) {
                    flag = flag || dfs(board, word, new boolean[board.length][board[0].length], i, j, 0);
                }
            }
        }
        return flag;
    }

    public boolean dfs(char[][] board, String word, boolean[][] marked, int i, int j, int index) {
        // 全部匹配
        if (index == word.length()) {
            return true;
        }
        // 越界
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(index) != board[i][j] || marked[i][j]) {
            return false;
        }
        // 只有后面为true的时候 才mark 为false的时候要重新放开
        marked[i][j] = true;
        boolean flag = dfs(board, word, marked, i + 1, j, index + 1) ||
                dfs(board, word, marked, i - 1, j, index + 1) ||
                dfs(board, word, marked, i, j + 1, index + 1) ||
                dfs(board, word, marked, i, j - 1, index + 1);
        if (!flag) marked[i][j] = false;
        return flag;
    }

    public static void main(String[] args) {
//        char[][] board = new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'},
//        };
        char[][] board = new char[][]{
                {'a'}
        };
        System.out.println(new Solution().exist(board, "a"));
    }
}

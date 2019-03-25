package ValidSudoku;

import java.util.HashSet;

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char temp = board[i][j];
                if (temp != '.') {
                    if (!set.add(temp + "row" + i) ||
                        !set.add(temp + "column" + j) ||
                        !set.add(temp + " " + (i / 3) + "-" + (j / 3) + "")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] test = {
                {'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
};
        Solution solution = new Solution();
        System.out.println(solution.isValidSudoku(test));
    }
}

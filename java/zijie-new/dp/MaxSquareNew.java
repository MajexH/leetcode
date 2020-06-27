package dp;

public class MaxSquareNew {

    public int maximalSquare(char[][] matrix) {
        int[][] length = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            length[i] = new int[matrix[i].length];
        }
        int maxLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    length[i][j] = Math.min(
                            i - 1 >= 0 ? length[i - 1][j] : 0,
                            Math.min(
                                    j - 1 >= 0 ? length[i][j - 1] : 0,
                                    i - 1 >= 0 && j - 1 >= 0 ? length[i - 1][j - 1] : 0
                            )
                    ) + 1;
                    maxLength = Math.max(maxLength, length[i][j]);
                }
            }
        }
        return maxLength * maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSquareNew().maximalSquare(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        }));
    }
}

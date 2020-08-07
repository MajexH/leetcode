package algorithmInterview.beforeStart;

public class FindInMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int i = 0, j = matrix[i].length - 1;
        while (i < matrix.length && j >= 0) {
            if (target > matrix[i][j]) i++;
            else if (target < matrix[i][j]) j--;
            else return true;
        }
        return false;
    }
}

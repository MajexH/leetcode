import java.util.Arrays;

public class SpiralMatrixII_59 {

    public int[][] generateMatrix(int n) {
        int counter = 1;
        int len = n * n;

        int[][] res = new int[n][n];

        int left = 0, right = n - 1, height = n - 1;

        while (counter < len) {
            for (int j = left; j < right; j++) {
                res[left][j] = counter++;
            }

            for (int i = left; i < height; i++) {
                res[i][right] = counter++;
            }

            for (int j = right; j > left; j--) {
                res[height][j] = counter++;
            }

            for (int i = height; i > left; i--) {
                res[i][left] = counter++;
            }


            left++;
            right--;
            height--;
        }

        if (left == right) res[left][right] = counter;

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new SpiralMatrixII_59().generateMatrix(3)));
        System.out.println(Arrays.deepToString(new SpiralMatrixII_59().generateMatrix(4)));
    }
}

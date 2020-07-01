package arrayandstr;

import java.util.Arrays;

public class SpiralMatrix {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, height = n - 1;
        int counter = 1;
        while (left < right) {

            for (int i = left; i < right; i++) {
                res[left][i] = counter++;
            }

            for (int i = left; i < height; i++) {
                res[i][right] = counter++;
            }

            for (int i = right; i > left; i--) {
                res[height][i] = counter++;
            }

            for (int i = height; i > left; i--) {
                res[i][left] = counter++;
            }
            left++;
            right--;
            height--;
        }
        // 处理奇数的问题
        if (left == right) res[left][right] = counter;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new SpiralMatrix().generateMatrix(1)));
    }
}

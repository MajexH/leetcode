package tencent.strAndArray;

import java.util.Arrays;

public class SpiralMatrix {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int index = 1;
        int height = n - 1, width = n - 1, left = 0;

        while (left < width) {

            for (int i = left; i < width; i++) {
                res[left][i] = index++;
            }
            for (int i = left; i < height; i++) {
                res[i][width] = index++;
            }
            for (int i = width; i > left; i--) {
                res[height][i] = index++;
            }
            for (int i = height; i > left; i--) {
                 res[i][left] = index++;
            }

            left++;
            width--;
            height--;
        }
        if (left == width) {
            res[left][width] = index;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new SpiralMatrix().generateMatrix(3)));
        System.out.println(Arrays.deepToString(new SpiralMatrix().generateMatrix(4)));
    }
}

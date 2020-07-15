package highFrequency.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author majexh
 */
public class SpiralArray {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int left = 0, width = matrix[0].length - 1, height = matrix.length - 1;
        while (left < width && left < height) {

            for (int i = left; i < width; i++) {
                res.add(matrix[left][i]);
            }
            for (int i = left; i < height; i++) {
                res.add(matrix[i][width]);
            }
            for (int i = width; i > left; i--) {
                res.add(matrix[height][i]);
            }
            for (int i = height; i > left; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            width--;
            height--;
        }
        if (left == width) {
            for (int i = left; i <= height; i++) {
                res.add(matrix[i][width]);
            }
        } else if (left == height) {
            for (int i = left; i <= width; i++) {
                res.add(matrix[left][i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralArray().spiralOrder(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        }));
    }
}

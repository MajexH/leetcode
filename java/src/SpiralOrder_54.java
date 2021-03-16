import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int left = 0, right = matrix[left].length - 1, height = matrix.length - 1;

        // 因为可能只是出现一行的情况 所以 height > left
        while (left < right && height > left) {

            for (int j = left; j < right; j++) {
                res.add(matrix[left][j]);
            }

            for (int i = left; i < height; i++) {
                res.add(matrix[i][right]);
            }

            for (int j = right; j > left; j--) {
                res.add(matrix[height][j]);
            }

            for (int i = height; i > left; i--) {
                res.add(matrix[i][left]);
            }

            left++;
            right--;
            height--;
        }

        // 竖着加一行
        if (left == right && height >= left) {
            while (left <= height) {
                res.add(matrix[left++][right]);
            }
        }
        // 横着加一行
        if (height == left && left <= right) {
            while (left <= right) {
                res.add(matrix[height][left++]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralOrder_54().spiralOrder(new int[][]{{6,9,7}}));
        System.out.println(new SpiralOrder_54().spiralOrder(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        }));
    }
}

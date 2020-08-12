package chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrderPrint_29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[left].length - 1, height = matrix.length - 1;
        while (left < right && left < height) {
            for (int i = left; i < right; i++) {
                res.add(matrix[left][i]);
            }
            for (int i = left; i < height; i++) {
                res.add(matrix[i][right]);
            }
            for (int i = right; i > left; i--) {
                res.add(matrix[height][i]);
            }
            for (int i = height; i > left; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            right--;
            height--;
        }
        if (left == right && left == height) {
            res.add(matrix[left][left]);
        } else {
            if (left < right && left == height) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[left][i]);
                }
            }
            else if (left < height && left == right) {
                for (int i = left; i <= height; i++) {
                    res.add(matrix[i][right]);
                }
            }
        }
        int[] resInts = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resInts[i] = res.get(i);
        }
        return resInts;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SpiralOrderPrint_29().spiralOrder(new int[][]{
                {1,2,3,4,5,6,7,8,9,10},
                {11,12,13,14,15,16,17,18,19,20}
        })));
    }
}

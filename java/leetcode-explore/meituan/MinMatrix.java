package meituan;

import java.util.Locale;
import java.util.Scanner;

public class MinMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // 找到对应的最小矩阵
        int i = n;
        // 从行开始折半查找 知道最后 i == 1

        // 因为是在原数组的基础上每次向下反转 所以其实反转过一次之后 一定是 偶数
        // 如果有一个数组的长度 不为 偶数 那么一定有有问题
        while ((i & 1) == 0) {
            // 检查每一列
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < i / 2; k++) {
                    // 头应该跟尾巴对照
                    if (matrix[k][j] != matrix[i - 1 - k][j]) {
                        printMatrix(matrix, i);
                        return;
                    }
                }
            }
            i /= 2;
        }
        // 出来是 奇数
        printMatrix(matrix, i);
    }

    public static void printMatrix(int[][] matrix, int row) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                builder.append(matrix[i][j]);
                builder.append(" ");
            }
            System.out.println(builder.toString().trim());
            builder.delete(0, builder.length());
        }
    }
}

import java.util.Arrays;

public class SetZeros_73 {

    // matrix 中 有一个 0 那么其 横竖 都会被变为 0
    // 求转换后的 matrix
    // 要求需要使用常量空间
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        // 因为是横竖都会被变成 0 那么在变换的时候可以吧这些状态 填充到 第一行 和 第一列上

        boolean col0HasZero = false, row0HasZero = false;

        for (int i = 0; i < matrix.length; i++) {
            // 第一列为 true
            if (matrix[i][0] == 0) {
                col0HasZero = true;
                break;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                row0HasZero = true;
                break;
            }
        }

        // 压缩为 0 的状态
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    // 这一行的状态 填充到 头上
                    matrix[i][0] = 0;
                    // 同理 列也是
                    matrix[0][j] = 0;
                }
            }
        }

        // 重新设置 0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 设置 0 行 和 0 列的状态

        if (col0HasZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if (row0HasZero) {
            Arrays.fill(matrix[0], 0);
        }
    }
}

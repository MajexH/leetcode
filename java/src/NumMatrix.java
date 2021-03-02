public class NumMatrix {
    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        this.sum = new int[matrix.length + 1][];
        // sum[i][j] 表示 matrix[i][j] 左上角的值
        // matrix[i][j] 可以尤其左侧 和 上侧的加起来得到 同时减去重合的部分 以及 本行上下的数字合成
        this.sum[0] = new int[matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            this.sum[i + 1] = new int[matrix[i].length + 1];
            for (int j = 0; j < matrix[i].length; j++) {
                this.sum[i + 1][j + 1] = this.sum[i + 1][j] + this.sum[i][j + 1] - this.sum[i][j] + matrix[i][j];
            }
        }
    }

    // 既然 sum[i][j] 表示左上部分 那么这个区域 也可以由 三部分组成
    // 一部分是 row2 col2 到左上角
    // 然后减去 row2 col1 左侧 减去 row1 col2 上侧
    // 同时加上 重复减去的部分
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return this.sum[row2 + 1][col2 + 1] - this.sum[row2 + 1][col1] - this.sum[row1][col2 + 1] + this.sum[row1][col1];
    }

    // 下面这种做法 每次去找 range 的时候 需要
//    public NumMatrix(int[][] matrix) {
//        this.sum = new int[matrix.length + 1][];
//        for (int i = 0; i < matrix.length; i++) {
//            getRowSum(i, matrix[i]);
//        }
//    }
//
//    private void getRowSum(int i, int[] nums) {
//        this.sum[i] = new int[nums.length + 1];
//        for (int j = 1; j <= nums.length; j++) {
//            this.sum[i][j] = this.sum[i][j - 1] + nums[j - 1];
//        }
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int res = 0;
//        for (int i = row1; i <= row2; i++) {
//            res += this.sum[i][col2 + 1] - this.sum[i][col1];
//        }
//        return res;
//    }

    public static void main(String[] args) {
        System.out.println(new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        }).sumRegion(2,1,4,3));
    }
}

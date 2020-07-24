package chapter2.array;

public class FindInMatrix {

    /**
     * 给定一个列数据递增的数组并且行数据递增的数组
     * 找到一个数字等于 target 的
     * @param matrix 需要寻找的数组
     * @param target 需要找到的数字
     * @return 找到返回 true 否则返回 false
     */
    public boolean findInMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int x = 0, y = matrix[x].length - 1;
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                x++;
            } else if (matrix[x][y] > target) {
                y--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new FindInMatrix().findInMatrix(new int[][]{
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        }, 5));
    }
}

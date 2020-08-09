package algorithmInterview.heapAndStackAndQueue;

public class KthSmallestInMatrix {

    public int getCount(int[][] matrix, int target) {
        int counter = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt <= target) counter++;
            }
        }
        return counter;
    }

    public int kthSmallest(int[][] matrix, int k) {
        // matrix 的最大最小值 在这个范围上做 二分
        int i = matrix[0][0], j = matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1];
        while (i <= j) {
            if (i == j) return i;
            int mid = (i + j) / 2;
            // 因为 k 是要找的是 第k小 因此只需要找到 mid 对应的前面的数有多少即可
            int midCounter = getCount(matrix, mid);
            if (midCounter < k) i = mid + 1;
            // 大于等于 说明有重复 因此要继续往前找
            else j = mid;
        }
        return i;
    }
}

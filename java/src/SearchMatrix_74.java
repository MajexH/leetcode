public class SearchMatrix_74 {

    // matrix 每一行是递增的 而且 下一行的头要小于上一行的尾
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (matrix[mid][0] > target) {
                j = mid - 1;
            } else if (matrix[mid][0] < target) {
                if (matrix[mid][matrix[mid].length - 1] >= target) {
                    return binarySearch(matrix[mid], target);
                } else i = mid + 1;
            } else {
                return true;
            }
        }
        return false;

    }

    public boolean binarySearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SearchMatrix_74().searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 3));
        System.out.println(new SearchMatrix_74().searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 13));
        System.out.println(new SearchMatrix_74().searchMatrix(new int[][]{
                {1},
                {3}
        }, 3));
    }
}

package chapter6;

public class NumberEqualsIndexInSortedArray_53_2 {

    // 在一个递增数组中 找到下标等于其数字的位置
    public int getNumberEqualsIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int i = 0, j = nums.length - 1;
        int mid;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] > mid) {
                j = mid - 1;
            } else if (nums[mid] < mid) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        // 没找到
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new NumberEqualsIndexInSortedArray_53_2().getNumberEqualsIndex(new int[]{-3,-1,1,3,5}));
    }
}

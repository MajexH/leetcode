package chapter6;

public class FindFrequencyInSortedArray_53 {

    public int leftBinarySearch(int[] nums, int i, int j, int target) {
        int mid;
        while (i < j) {
            mid = (i + j) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                j = mid;
            }
        }
        return nums[i] == target ? i : -1;
    }

    public int rightBinarySearch(int[] nums, int i, int j, int target) {
        int mid;
        while (i < j) {
            mid = (i + j + 1) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid;
            }
        }
        return nums[i] == target ? i : -1;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = leftBinarySearch(nums, 0, nums.length - 1, target);
        if (left == -1) return 0;
        else return rightBinarySearch(nums, 0, nums.length - 1, target) - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(new FindFrequencyInSortedArray_53().search(new int[]{5,7,7,8,8,10}, 11));
    }
}

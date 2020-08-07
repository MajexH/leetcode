package highFrequency.array;

public class FirstAndLastIndexInSortedArray {

    public int binarySearchLeft(int[] nums, int i, int j, int target) {
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return target == nums[i] ? i : -1;
    }

    public int binarySearchRight(int[] nums, int i, int j, int target) {
        while (i < j) {
            int mid = (i + j + 1) / 2;
            if (nums[mid] <= target) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        return target == nums[i] ? i : -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        int left = binarySearchLeft(nums, 0, nums.length - 1, target);
        if (left == -1) return new int[]{-1,-1};
        return new int[]{left,binarySearchRight(nums, 0, nums.length - 1, target)};
    }
}

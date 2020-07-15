package highFrequency.array;

import java.util.Arrays;

public class FindTheFirstAndLastIndexInSorted {

    public int binaryLeftSearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
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
        if (nums[i] != target) return -1;
        else return i;
    }

    public int binaryRightSearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
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

        if (nums[i] == target) return i;
        else return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        int left = binaryLeftSearch(nums, target);
        if (left == -1) return new int[]{-1,-1};
        return new int[]{ left, binaryRightSearch(nums, target) };
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindTheFirstAndLastIndexInSorted().searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }
}

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray_34 {

    public int mostLeftBinarySearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (target > nums[mid]) {
                i = mid + 1;
            } else if (target < nums[mid]) {
                j = mid - 1;
            } else {
                j = mid;
            }
        }
        return i < nums.length && nums[i] == target ? i : -1;
    }

    public int mostRightBinarySearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j + 1) / 2;
            if (target > nums[mid]) {
                i = mid + 1;
            } else if (target < nums[mid]){
                j = mid - 1;
            } else {
                i = mid;
            }
        }
        return i < nums.length && nums[i] == target ? i : -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{ -1, -1 };
        return new int[]{ mostLeftBinarySearch(nums, target), mostRightBinarySearch(nums, target) };
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindFirstandLastPositionofElementinSortedArray_34().searchRange(new int[]{2,2}, 3)));
    }
}

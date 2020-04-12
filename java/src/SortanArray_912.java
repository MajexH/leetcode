import java.util.Arrays;

public class SortanArray_912 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int j = partition(nums, start, end);
        quickSort(nums, start, j - 1);
        quickSort(nums, j + 1, end);
    }

    public int partition(int[] nums, int start, int end) {
        int base = nums[start];
        int i = start, j = end + 1;
        while (true) {
            while (++i <= end && nums[i] < base) if (i == end) break;
            while (nums[--j] > base) if (j == start) break;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortanArray_912().sortArray(new int[]{5,2,3,1})));
    }
}

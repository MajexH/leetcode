import java.util.Arrays;

public class QuickSortNew {

    public void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        recursion(nums, 0, nums.length - 1);
    }

    private void recursion(int[] nums, int start, int end) {
        if (start >= end) return;
        int j = partition(nums, start, end);
        recursion(nums, start, j - 1);
        recursion(nums, j + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int base = nums[start];
        int i = start, j = end + 1;
        while (true) {
            // 从小到大排列
            while (++i < nums.length && nums[i] < base) if (i == end) break;
            while (--j >= 0 && nums[j] > base) if (j == start) break;
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
        int[] a = new int[]{ 1 };
        new QuickSortNew().quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}

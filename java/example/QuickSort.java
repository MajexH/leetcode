import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int j = partition(nums, start, end);
        quickSort(nums, start, j - 1);
        quickSort(nums, j + 1, end);
    }

    public static int partition(int[] nums, int start, int end) {
        int base = nums[start];
        int i = start, j = end + 1;
        while (true) {
            // 先判断++i 是因为有可能越界
            while (++i <= end && base > nums[i]) if (i == end) break;
            while (base < nums[--j]) if (start == j) break;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{ 1, 32, 4, 21, 12, 21, 34, 124, 12 };
        QuickSort.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}

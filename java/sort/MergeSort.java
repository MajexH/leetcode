import java.util.Arrays;

public class MergeSort {

    public void MergeSort(int[] nums) {
        recursion(nums, 0, nums.length - 1);
    }

    public void recursion(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        recursion(nums, start, mid);
        recursion(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1;
        int counter = 0;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                temp[counter++] = nums[i];
                i++;
            } else {
                temp[counter++] = nums[j];
                j++;
            }
        }
        while (i <= mid) {
            temp[counter++] = nums[i];
            i++;
        }
        while (j <= end) {
            temp[counter++] = nums[j];
            j++;
        }
        for (int indexN = start, indexT = 0; indexN <= end; indexN++, indexT++) {
            nums[indexN] = temp[indexT];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{ 3213,432,321,434,5423,43,453,1 };
        new MergeSort().MergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}

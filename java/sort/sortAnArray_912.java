import java.util.Arrays;

public class sortAnArray_912 {

    // 归并和快排
    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public void merge(int[] nums, int start, int mid, int end) {
        int i = start, j = mid + 1, index = 0;
        int[] temp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                temp[index] = nums[i];
                i++;
            } else {
                temp[index] = nums[j];
                j++;
            }
            index++;
        }
        while (i <= mid) temp[index++] = nums[i++];
        while (j <= end) temp[index++] = nums[j++];
        for (int indexN = start, indexT = 0; indexN <= end; indexN++, indexT++) {
            nums[indexN] = temp[indexT];
        }
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new sortAnArray_912().sortArray(new int[]{5, 2, 3, 1})));
    }
}

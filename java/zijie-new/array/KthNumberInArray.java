package array;

import java.util.Arrays;

public class KthNumberInArray {

    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(nums, start, end);
        }
        System.out.println(Arrays.toString(nums));
        return nums[k - 1];
    }

    public int partition(int[] nums, int start, int end) {
        int base = nums[start];
        int i = start, j = end + 1;
        while (true) {
            while (++i <= end && base < nums[i]) if (i == end) break;
            while (--j >= start && base > nums[j]) if (j == start) break;
            if (i >= j) break;
            swap(nums,i ,j);
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
        System.out.println(new KthNumberInArray().findKthLargest(new int[]{2,1},1));
    }
}

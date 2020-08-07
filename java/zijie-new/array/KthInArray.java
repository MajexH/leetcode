package array;

import java.util.Arrays;

public class KthInArray {

    public int findKthLargest(int[] nums, int k) {
        // 找不到
        if (nums == null) return -1;
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
        return nums[k - 1];
    }

    public int partition(int[] nums, int start, int end) {
        int base = nums[start];
        int i = start, j = end + 1;
        while (true) {
            while (++i < nums.length && nums[i] > base)
                if (i == end) break;
            while (--j >= 0 && nums[j] < base)
                if (j == start) break;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        System.out.println(new KthInArray().findKthLargest(new int[]{1}, 1));
    }
}

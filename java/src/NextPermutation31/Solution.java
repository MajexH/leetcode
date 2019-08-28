package NextPermutation31;

import java.util.Arrays;

public class Solution {

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public void reverse(int[] nums, int start) {
        for (int i = start, j = nums.length - 1; i <= j; i++, j--) {
            swap(nums, i, j);
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        // 找到第一个倒序
        while (i >= 1 && nums[i] <= nums[i - 1] ) {
            i--;
        }
        // 如果不是完全倒叙
        if (i >= 1) {
            i--;
            // 在右边找到刚刚好大于他的数
            int j = nums.length - 1;
            while (j >= 0) {
                if (nums[j] > nums[i]) {
                    break;
                }
                j--;
            }
            swap(nums, i, j);
            reverse(nums, i + 1);
        } else {
            // 如果是完全倒叙 则需要将所有的翻转
            reverse(nums, i);
        }
    }

    public static void main(String[] args) {
        int [] a = new int[]{3, 2, 1};
        new Solution().nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
}

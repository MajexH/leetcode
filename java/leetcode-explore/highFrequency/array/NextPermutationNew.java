package highFrequency.array;

import java.util.Arrays;

public class NextPermutationNew {

    public void swap(int[] nums, int i, int j) {
        if (nums[i] == nums[j]) {
            return;
        }

        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public void reverse(int[] nums, int start) {
        for (int i = start, j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    // in place 的变换
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // 找到逆序点
        int i = nums.length - 1;

        while (i >= 1 && nums[i - 1] >= nums[i]) {
            i--;
        }

        if (i == 0) {
            // 完全逆序 题目要求全部转换回来
            reverse(nums, 0);
            return;
        }
        int j = nums.length - 1;
        // 非完全逆序 找到后面的数字中第一个大于 i - 1 的数
        while (j >= i && nums[j] <= nums[i - 1]) {
            j--;
        }

        swap(nums, i - 1, j);
        reverse(nums, i);
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,1,1};
        new NextPermutationNew().nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
}

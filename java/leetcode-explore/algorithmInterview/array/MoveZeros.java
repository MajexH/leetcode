package algorithmInterview.array;

import java.util.Arrays;

public class MoveZeros {

    public void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    // 实际上只需要双指针即可 相当于一个指向原始的数组的指针 一个指向不是 0 的位置的指针
    public void moveZeroes(int[] nums) {
        int lastNotZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNotZero++] = nums[i];
            }
        }
        for (int i = lastNotZero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 这个方法 相当于 o(n^2) 的交换
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int j = i;
                // 往后找到一个 不为 0 的地方
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                if (j < nums.length)
                    swap(nums, i, j);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{0,1,0,3,12,0,32};
        new MoveZeros().moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }
}

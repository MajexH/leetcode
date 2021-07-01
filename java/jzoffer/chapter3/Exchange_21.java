package chapter3;

import java.util.Arrays;

public class Exchange_21 {

    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) {
                i++;
            }
            while (i < j && (nums[j] & 1) == 0) {
                j--;
            }
            if (i >= j) break;

            if (nums[i] != nums[j]) {
                nums[i] = nums[i] ^ nums[j];
                nums[j] = nums[i] ^ nums[j];
                nums[i] = nums[i] ^ nums[j];
            }
            i++;
            j--;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Exchange_21().exchange(new int[]{1, 3, 5})));
    }
}

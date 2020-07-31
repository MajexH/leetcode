package chapter3;

public class MoveOddAhead_21 {

    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < nums.length && nums[i] % 2 == 1) {
                i++;
            }
            while (j >= 0 && nums[j] % 2 == 0) {
                j--;
            }
            if (i >= j) break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}

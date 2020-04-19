import java.util.Arrays;

public class SwapArray {

    /**
     * 给定一个数组 有 2 * n个数 其中 n 个奇数 n个偶数
     * 实现一个算法 让奇数的对应的下标为奇数 偶数 对应的下标为偶数
     * @param nums
     */
    public void swapArray(int[] nums) {
        if (nums.length <= 1 || nums.length % 2 != 0) return;
        int oddIndex = 1, evenIndex = 0;
        while (oddIndex < nums.length && evenIndex < nums.length) {
            if (nums[oddIndex] % 2 == 0 && nums[evenIndex] % 2 == 1) {
                swap(nums, oddIndex, evenIndex);
                oddIndex += 2;
                evenIndex += 2;
            } else if (nums[oddIndex] % 2 == 1) {
                oddIndex += 2;
            } else if (nums[evenIndex] % 2 == 1) {
                evenIndex += 2;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = new int[]{ 1,2,3,4,5,6 };
        new SwapArray().swapArray(test);
        System.out.println(Arrays.toString(test));
    }
}

package ali;

import java.util.Arrays;

public class MaximumProduct {

    // 输出三个数的最大乘积
    public int maximumProduct(int[] nums) {
        // 找不到
        if (nums == null || nums.length < 3) return -1;

        Arrays.sort(nums);

        // 要么是最大的三个正数乘积 要么是两个最小的负数 * 最大的正数
        return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3], nums[0] * nums[1] * nums[nums.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(new MaximumProduct().maximumProduct(new int[]{1,2,3}));
        System.out.println(new MaximumProduct().maximumProduct(new int[]{1,2,3,4}));
        System.out.println(new MaximumProduct().maximumProduct(new int[]{-1,-2,-3}));
    }
}

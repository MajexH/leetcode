package highFrequency;

public class MaxSubSum {

    // 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (sum < 0) {
                // 如果前面的和小于0
                // 当前这个数加上这个和 < 当前这个数
                // 不如重新开始
                sum = 0;
            }
            sum += num;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }


}

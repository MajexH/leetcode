package algorithmInterview.array;

public class MaxProduct {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0], min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 这个地方 如果 nums[i] 是小于 0 的话
            // 最大最小值 必须翻过来 因为带了负号
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            // 跟 nums[i] 比较的原因是因为这个数组 必须是连续的
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            // 因为求得是一个一个 子数组的 max 因此要选取之中的最大值
            res = Math.max(res, max);
        }
        return res;
    }
}

public class MaximumProductSubarray_152 {

    // 找到最大的子数组乘积
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        // 保存 nums 里面的乘积的 最大最小值
        int max = nums[0], min = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // 负数的话 会让最小值和最大值交换
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            // 这儿这么选择的原因是 要么最大最小值选前面的乘积
            // 要么重新开始
            max = Math.max(max * num, num);
            min = Math.min(num * min, num);
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumProductSubarray_152().maxProduct(new int[]{-2,0,-1}));
    }
}

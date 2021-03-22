public class MaxAscendingSum_1800 {

    public int maxAscendingSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // pair 保存前一个数字 以及 其最长的上升序列的和
        int[] pair = new int[]{Integer.MIN_VALUE, 0};

        int res = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > pair[0]) {
                pair[0] = num;
                pair[1] += num;
            } else {
                // 重新计算
                pair[0] = num;
                pair[1] = num;
            }

            res = Math.max(res, pair[1]);
        }

        return res;
    }
}

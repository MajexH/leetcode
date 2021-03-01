public class NumArray {

    private int[] sum;

    // 303 题目
    public NumArray(int[] nums) {
        this.sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            this.sum[i] = this.sum[i - 1] + nums[i - 1];
        }
    }

    // 包含 i, j 两点的
    public int sumRange(int i, int j) {
        // 范围检测
        if (j + 1>= this.sum.length || i < 0) {
            return -1;
        }
        return this.sum[j + 1] - this.sum[i];
    }
}

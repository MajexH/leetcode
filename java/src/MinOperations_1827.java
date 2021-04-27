public class MinOperations_1827 {

    public int minOperations(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) continue;
            res += nums[i - 1] + 1 - nums[i];
            nums[i] = nums[i - 1] + 1;
        }
        return res;
    }
}

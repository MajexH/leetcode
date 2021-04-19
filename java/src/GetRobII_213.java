public class GetRobII_213 {

    // 首尾相连的循环数组的 rob
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(getRob(nums, 0, nums.length - 1), getRob(nums, 1, nums.length));
    }


    private int getRob(int[] nums, int start, int end) {
        int rob = 0;
        int notRob = 0;

        while (start < end) {
            int tmp = rob;
            rob = notRob + nums[start];
            notRob = Math.max(notRob, tmp);
            start++;
        }
        return Math.max(rob, notRob);
    }
}

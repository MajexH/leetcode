package algorithmInterview.dp;

public class HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int take = nums[0];
        int notTake = 0;
        for (int i = 1; i < nums.length; i++) {
            int notTakeRem = notTake, takeRem = take;
            take = notTake + nums[i];
            notTake = Math.max(takeRem, notTakeRem);
        }
        return Math.max(take, notTake);
    }
}

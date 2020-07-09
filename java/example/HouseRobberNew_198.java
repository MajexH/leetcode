public class HouseRobberNew_198 {

    public int rob(int[] nums) {
        if (nums.length <= 0) return 0;
        // 保存前拿了前一个的最大值
        int take = nums[0];
        // 保存不拿前一个的最大值
        int notTake = 0;
        for (int i = 1; i < nums.length; i++) {
            int preTake = take;
            take = notTake + nums[i];
            notTake = Math.max(preTake, notTake);
        }
        return Math.max(take, notTake);
    }
}

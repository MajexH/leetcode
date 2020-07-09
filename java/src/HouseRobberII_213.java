public class HouseRobberII_213 {

    // 这个是环形的
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        // 相当于 0 号不拿，则直接可以到最后一个
        int startFromOne = getMaxRob(nums, 1, nums.length - 1);
        int startFromTwo = nums[0] + getMaxRob(nums, 2, nums.length - 2);
        return Math.max(startFromOne, startFromTwo);
    }

    public int getMaxRob(int[] nums, int start, int end) {
        if (start > end || nums.length == 0) return 0;
        int take = nums[start];
        int notTake = 0;
        for (int i = start + 1; i <= end; i++) {
            int preTake = take;
            take = notTake + nums[i];
            notTake = Math.max(preTake, notTake);
        }
        return Math.max(take, notTake);
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobberII_213().rob(new int[]{ 2,3,2 }));
    }
}

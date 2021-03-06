package tencent.dp;

public class Rob {

    public int rob(int[] nums) {
        // 分别保存 当前这个拿或者不拿的最大值
        int take = 0;
        int notTake = 0;

        for (int num : nums) {
            int tmp = take;
            // 当前这个拿 前面那个只能不拿
            take = notTake + num;
            // 当前这个不拿 前面拿不拿都一样
            notTake = Math.max(tmp, notTake);
        }

        return Math.max(take, notTake);
    }
}

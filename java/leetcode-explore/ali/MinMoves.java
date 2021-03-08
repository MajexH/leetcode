package ali;

import java.util.Arrays;

public class MinMoves {

    // 寻找最后成为一个数的数值 - min
    public int minMoves(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            res += nums[i] - nums[0];
        }
        return res;
    }
}

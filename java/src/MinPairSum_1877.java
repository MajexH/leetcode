import java.util.Arrays;

public class MinPairSum_1877 {

    // 最小的最大数对和
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            res = Math.max(res, nums[i] + nums[j]);
        }
        return res;
    }
}

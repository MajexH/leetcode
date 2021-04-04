import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfArithmeticSlices_413 {

    // 找到等差数列的个数
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfArithmeticSlices_413().numberOfArithmeticSlices(new int[]{1,2,3,4}));
    }
}

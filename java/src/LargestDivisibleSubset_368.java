import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset_368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        // 从小到大排序

        int[] dp = new int[nums.length];
        int[] last = new int[nums.length];
        Arrays.fill(dp, -1);
        Arrays.fill(last, -1);

        // 最大的长度 & 这个长度的结尾数字
        int max = Integer.MIN_VALUE, end = -1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // nums[i] 一定大于 nums[j]
                if ((nums[i] % nums[j]) == 0 && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                    last[i] = j;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
                end = i;
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i = end; i != -1; i = last[i]) {
            res.add(nums[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LargestDivisibleSubset_368().largestDivisibleSubset(new int[]{1,2,3}));
    }
}

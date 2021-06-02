import java.util.HashMap;
import java.util.Map;

public class CheckSubarraySum_523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return false;
        // 两个数之间的和 % k == 0 说明 前缀和的两个数其余数相等
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, -1);
        int remain = 0;
        for (int i = 0; i < nums.length; i++) {
            remain = (remain + nums[i]) % k;
            if (memo.containsKey(remain)) {
                int pre = memo.get(remain);
                if (i - pre >= 2) return true;
            } else {
                // 把最前面的放进去 这样一定能够找到最长的结果
                memo.put(remain, i);
            }
        }
        return false;
    }

    public boolean checkSubarraySumBruteForce(int[] nums, int k) {
        if (nums == null || nums.length == 0) return true;

        int[] sum = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                if ((sum[i] - sum[j]) % k == 0) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CheckSubarraySum_523().checkSubarraySum(new int[]{23,2,4,6,6}, 7));
        System.out.println(new CheckSubarraySum_523().checkSubarraySum(new int[]{23,2,6,4,7}, 6));
        System.out.println(new CheckSubarraySum_523().checkSubarraySum(new int[]{23,2,6,4,7}, 13));
    }
}

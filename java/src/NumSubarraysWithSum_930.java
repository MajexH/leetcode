import java.util.HashMap;
import java.util.Map;

public class NumSubarraysWithSum_930 {

    // 前缀和优化 只需要知道前面有几个 前缀和 就可以优化到 o(n)
    public int numSubarraysWithSumOptimal(int[] nums, int goal) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            // 保存前缀和的数量
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += num;

            // 有多少个之前的前缀和 减去 goal 可以得到
            res += map.getOrDefault(sum - goal, 0);
        }

        return res;
    }

    // 前缀和求解 直接超时 因为是 o(n^2)
    public int numSubarraysWithSumUsingPreviousSum(int[] nums, int goal) {
        int[] sum = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int res = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i; j++) {
                 if (sum[i] - sum[j] == goal) {
                     res++;
                 }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //System.out.println(new NumSubarraysWithSum_930().numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
        //System.out.println(new NumSubarraysWithSum_930().numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));
    }
}

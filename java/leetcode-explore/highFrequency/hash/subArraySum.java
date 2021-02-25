package highFrequency.hash;

import java.util.HashMap;
import java.util.Map;

public class subArraySum {

    // 可以用 map 保存前缀和 可以做到边移动 边算和
    public int subarraySum(int[] nums, int k) {
        // 保存前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 边界 因为 0 + sum = k 也是一种解
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    // 和为 K 的连续子数组的个数
    // 用一个数组来保存前缀和 可以很方便的找到结果
    // 不过时间相对较长
    public int subarraySumWithSum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            sum[i] += nums[i - 1] + sum[i - 1];
        }
        int res = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] == k) {
                    res++;
                }
            }
        }
        return res;
    }

    // 和为 K 的连续子数组的个数
    // 不能使用滑动窗口 因为没办法判断左移窗口的时机 因为里面 正负数均有
    // AC 0.5 滑动窗口
    public int subarraySumWithSlidingWindow(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            // 有可能要的和就是 0
            if (sum == k && r != 0) {
                res++;
            }
            sum += nums[r];
            // nums[l] 大于 0 的时候 减去 l 才可以让 sum 减小
            while (l < r && nums[l] > 0 && sum > k) {
                sum -= nums[l];
                l++;
            }

            while (l < r && nums[l] < 0 && sum < k) {
                sum -= nums[l];
                l++;
            }
            r++;
        }
        while (l < r) {
            if (sum == k) {
                res++;
            }
            sum -= nums[l];
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new subArraySum().subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(new subArraySum().subarraySum(new int[]{1}, 0));
        System.out.println(new subArraySum().subarraySum(new int[]{-1, -1, 1}, 0));
        System.out.println(new subArraySum().subarraySum(new int[]{1, -1, 0}, 0));
    }
}

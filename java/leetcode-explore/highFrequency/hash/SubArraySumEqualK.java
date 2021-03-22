package highFrequency.hash;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualK {

    // 找到和为 k 的连续子数组的个数
    public int subarraySum(int[] nums, int k) {
        // 保存和为 key 的连续子数组的个数的 value
        // 保存的都是从左边第一个开始的
        Map<Integer, Integer> map = new HashMap<>();
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

    public static void main(String[] args) {
        System.out.println(new SubArraySumEqualK().subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(new SubArraySumEqualK().subarraySum(new int[]{1}, 0));
        System.out.println(new SubArraySumEqualK().subarraySum(new int[]{-1, -1, 1}, 0));
        System.out.println(new SubArraySumEqualK().subarraySum(new int[]{1, -1, 0}, 0));
    }
}

import java.util.HashMap;
import java.util.Map;

public class SubSequenceSumIsK {

    // 下面那个算法计算前缀和的时候 采用了 遍历的方式
    // 这样其实很多都是重复的计算
    public int subarraySum1(int[] nums, int k) {
        // 保存前缀和
        // key 表示前缀和 value 表示这个前缀和对应有几个能形成
        Map<Integer, Integer> pre = new HashMap<>();
        // 边界条件
        pre.put(0, 1);
        int sum = 0, res = 0;
        for (int num : nums) {
            sum += num;
            // 表示从前缀和为 sum - k 到 当前的和为 sum 的 num 这个数
            // 可以形成一个合为 k 的子数组 因为 sum - (sum - k) = k
            if (pre.containsKey(sum - k)) {
                res += pre.get(sum - k);
            }
            // 保存前缀和
            pre.put(sum, pre.getOrDefault(sum, 0) + 1);
        }
        System.out.println(pre);
        return res;
    }

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) res++;
                // 有可能为负数 所有不能有这个
                // else if (sum > k) break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SubSequenceSumIsK().subarraySum1(new int[]{1,2,3}, 3));
    }
}

import java.util.HashMap;
import java.util.Map;

public class SubarraySum_560 {

    // 数组中和为 k 的连续子数组的个数
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (memo.containsKey(sum - k)) {
                res += memo.get(sum - k);
            }
            memo.put(sum, memo.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SubarraySum_560().subarraySum(new int[]{-1, -1, 1},0));
    }
}

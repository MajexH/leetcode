import java.util.HashMap;
import java.util.Map;

public class FindMaxLength_525 {

    // 找到具有相同数量的01的最长连续子数组
    // 还是前缀和 但是得把参数压缩到一维
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int res = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, -1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            // 将 0 视为 -1 压缩状态
            sum = sum + (nums[i] == 1 ? 1 : -1);
            if (!memo.containsKey(sum)) {
                memo.put(sum, i);
                continue;
            }

            int preIndex = memo.get(sum);
            res = Math.max(res, i - preIndex);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindMaxLength_525().findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
    }
}

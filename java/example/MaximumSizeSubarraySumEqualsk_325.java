import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk_325 {


    /**
     * 给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。
     *
     * 注意:
     *  nums 数组的总和是一定在 32 位有符号整数范围之内的。
     *
     * 示例 1:
     *
     * 输入: nums = [1, -1, 5, -2, 3], k = 3
     * 输出: 4 
     * 解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。
     * 示例 2:
     *
     * 输入: nums = [-2, -1, 2, 1], k = 1
     * 输出: 2 
     * 解释: 子数组 [-1, 2] 和等于 1，且长度最长。
     * @param nums
     * @param k
     * @return
     */
    public int maxSubArrayLen(int[] nums, int k) {
        // map 保存的是前缀和 其实 key 是和为多少 value 是其 index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 和
            sum += num;
            // 如果现在已经有现在的前缀和 减去 之前的前缀和 有为 K 的
            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }
            // 如果当前的前缀和没有保存
            // 实际上 我觉得这个地方就可以用 List 来保存所有的下标
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        System.out.println(map);
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSizeSubarraySumEqualsk_325().maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1));
    }
}

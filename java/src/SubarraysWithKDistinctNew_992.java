import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarraysWithKDistinctNew_992 {

    public int subarraysWithKDistinct(int[] A, int K) {
        return getAtMostK(A, K) - getAtMostK(A, K - 1);
    }

    public int getAtMostK(int[] nums, int k) {
        // 找到 atMost K 的话简单 因为可以直接用下标减得到能够形成的长度
        // 统计 一个区间内能够形成最多为 K 个 distinct 的数字
        int res = 0;
        Map<Integer, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);
            while (window.size() > k) {
                int count = window.get(nums[left]);
                if (count == 1) {
                    window.remove(nums[left]);
                } else {
                    window.put(nums[left], count - 1);
                }
                left++;
            }
            res += right - left + 1;
            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SubarraysWithKDistinct_992().subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
        System.out.println(new SubarraysWithKDistinct_992().subarraysWithKDistinct(new int[]{1,2,1,3,4}, 3));

        System.out.println(new SubarraysWithKDistinctNew_992().subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
        System.out.println(new SubarraysWithKDistinctNew_992().subarraysWithKDistinct(new int[]{1,2,1,3,4}, 3));
    }
}

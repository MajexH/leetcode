import java.util.HashMap;
import java.util.Map;

public class MaxOperations_1679 {

    // 每一步从数组中移除一对和为 k 的数 问能操作几次
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(k - num)) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                continue;
            }
            map.put(k - num, map.get(k - num) - 1);
            if (map.get(k - num) == 0) map.remove(k - num);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxOperations_1679().maxOperations(new int[]{3,1,5,1,1,1,1,1,2,2,3,2,2}, 1));
    }
}

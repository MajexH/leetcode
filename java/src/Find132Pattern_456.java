import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Find132Pattern_456 {

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        // min[i] 表示 nums[i] 前面的最小值
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        LinkedList<Integer> stack = new LinkedList<>();

        // 这儿相当于在遍历 j 因此用一个 stack 来保存 j 之后的最大值
        for (int j = nums.length - 1; j >= 0; j--) {
            // nums[j] 是 aj min[j] 是 ai 现在只需要找到 ak
            if (nums[j] > min[j]) {
                // 这样 stack 里面的 一定是 大于 min[j] 现在只需要知道 里面是否还存在 一个数
                // 是小于 nums[j] 即可
                while (!stack.isEmpty() && stack.peek() <= min[j])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }

    public boolean find132pattern1(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        // 因为 a[i] 的值越小越好，因此用 min[i] 表示 下标为 i 的时候的最小值作为 a[i] 的值
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        // 现在 a[i] 取 min[j] 然后遍历 [j] 的取值
        // 相当于需要在 数组的后面 找到一个 k 满足 min[j] < a[k] < a[j]
        // 用 treemap 来跟踪 j 分割的后面的 key 是什么
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // 记录每个数 的数量
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 这儿相当于在遍历 j
        for (int j = 0; j < nums.length - 1; j++) {
            // 这种不符合 132
            if (nums[j] <= min[j]) {
                if (map.get(nums[j]) - 1 == 0) {
                    map.remove(nums[j]);
                } else {
                    map.put(nums[j], map.get(nums[j]) - 1);
                }
                continue;
            }
            // 其实这而就是要找 j 后面的数 存不存在 min[j] < nums[k] < nums[j]
            Integer lowerKey = map.lowerKey(nums[j]);
            if (lowerKey != null
                    && map.get(lowerKey) > 0
                    && min[j] < lowerKey) return true;
            if (map.get(nums[j]) - 1 == 0) {
                map.remove(nums[j]);
            } else {
                map.put(nums[j], map.get(nums[j]) - 1);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Find132Pattern_456().find132pattern(new int[]{-2,1,-2}));
    }
}

import java.util.*;
import java.util.stream.Collectors;

public class IsPossibleDivide_1296 {

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums == null || nums.length % k != 0) return false;
        // 排序后 保证我每次去遍历的对象都是从一个连续 k 个数中最小的开始
        Arrays.sort(nums);
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new LinkedList<>());
            }
            map.get(nums[i]).add(i);
        }
        // 标识已经访问过的对象
        boolean[] memo = new boolean[nums.length];

        for (int i = 0; i < nums.length;) {
            // 跳过已经访问的对象
            while (i < nums.length && memo[i]) i++;

            if (i >= nums.length) break;
            int min = nums[i];
            memo[map.get(min).removeFirst()] = true;
            if (map.get(min).size() == 0) map.remove(min);
            for (int j = 1; j < k; j++) {
                int last = min + j;
                if (!map.containsKey(last)) return false;
                memo[map.get(last).removeFirst()] = true;
                if (map.get(last).size() == 0) map.remove(last);
            }
        }
        return true;
    }

    public boolean isPossibleDivideBruteForce(int[] nums, int k) {
        if (nums == null || nums.length % k != 0) return false;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        PriorityQueue<Integer> pq = new PriorityQueue<>(list);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : list) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (!pq.isEmpty()) {
            int min = pq.poll();
            map.put(min, map.get(min) - 1);
            if (map.get(min) == 0) map.remove(min);
            for (int i = 1; i < k; i++) {
                if (!map.containsKey(min + i)) return false;
                pq.remove(min + i);
                map.put(min + i, map.get(min + i) - 1);
                if (map.get(min + i) == 0) map.remove(min + i);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsPossibleDivide_1296().isPossibleDivide(new int[]{16, 5, 15, 15, 20, 16, 20, 14, 21, 20, 19, 20, 12, 17, 13, 15, 11, 17, 18, 18, 11, 13, 13, 14, 14, 9, 20, 18, 10, 4, 4, 6, 15, 19, 8, 15, 7, 17, 15, 9, 24, 2, 23, 22, 26, 8, 21, 22, 14, 13, 16, 2, 25, 23, 17, 19, 17, 3, 22, 23, 19, 12, 21, 12, 16, 27, 28, 10, 13, 8, 24, 3, 22, 6, 10, 9, 14, 7, 11, 22, 11, 5, 16, 19, 21, 2, 8, 24, 16, 21, 7, 29, 18, 9, 10, 18, 6, 17, 21, 20}, 10));
        System.out.println(new IsPossibleDivide_1296().isPossibleDivide(new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11}, 3));
        System.out.println(new IsPossibleDivide_1296().isPossibleDivide(new int[]{1, 2, 4}, 3));
    }
}

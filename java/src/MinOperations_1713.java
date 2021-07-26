import java.util.*;

public class MinOperations_1713 {

    // 实际上这个题目是找 target arr 的最长公共子序列 但是 target arr 太长会超时
    // 所以要换个角度 因为 target 是 distinct 的
    // 所以可以将 arr 中 target 的数值 替换成 target 中数字的下标 并且删除不再 target 中的数字 因为也不用考虑这些
    // 那么现在 就需要知道 target 与 arr 中相同的最长子序列是多长即可
    // 而 target 是递增的 所以 arr 找到最长的递增子序列即可
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> targetMemo = new HashMap<>();

        for (int i = 0; i < target.length; i++) {
            targetMemo.put(target[i], i);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (!targetMemo.containsKey(num)) continue;
            list.add(targetMemo.get(num));
        }
        return target.length - lengthOfLIS(list.toArray(new Integer[0]));
    }

    public int lengthOfLIS(Integer[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }


    public static void main(String[] args) {
        System.out.println(new MinOperations_1713().minOperations(new int[]{5,1,3}, new int[]{9,4,2,3,4}));
        System.out.println(new MinOperations_1713().minOperations(new int[]{6,4,8,1,3,2}, new int[]{4,7,6,2,3,8,6,1}));
    }
}

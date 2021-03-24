import java.util.Deque;
import java.util.LinkedList;

public class Find132patternNew_456 {

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        int[] leftMin = new int[nums.length];
        leftMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        Deque<Integer> stack = new LinkedList<>();

        // 从后向前找 因为要找的是 j < k nums[j] > nums[k] 的结果
        // 那么只需要保存遍历的 j 之后的比 nums[j] 小 且比 leftMin 大的最大值 这样就可以满足要求了
        // 所以 stack 中保存的是 j 之后的 较大的值 如果能够在其中找到一个小于 nums[j] 的值 就证明可行
        for (int j = nums.length - 1; j >= 0; j--) {
            // 必须要比左侧最小的大 才能比较
            if (nums[j] > leftMin[j]) {
                // 因为要在 j 右边找一个更小的 nums[k] 所以 比 nums[j] 小的 都出栈
                // 比较其中的最大值与 leftMin 的大小既可以知道
                int remove = Integer.MIN_VALUE;
                while (!stack.isEmpty() && stack.peekLast() < nums[j]) {
                    remove = stack.removeLast();
                }
                if (remove > leftMin[j]) return true;
                stack.addLast(nums[j]);
            }
        }
        return false;
    }

    // 找到 1 3 2 模式
    // bruteforce 的方法 因为要找到 i < j < k 满足 nums[i] < nums[k] < nums[j] 的格式
    // 即中间的数是最大 那么 nums[i] 一定是最小 所以先维护一个 leftMin 表示从左侧开始的最小值
    // 然后开始遍历数组 找到一个 逆序数对 且逆序数对中的最小值 大于 leftMin 的值 即可找到
    // 所以是 o(n^2)
    public boolean find132patternBruteForce(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        int[] leftMin = new int[nums.length];
        leftMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }

        // 先固定一个最小值
        // 然后在找到一个逆序的点
        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > leftMin[i] && nums[i] > nums[j]) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Find132patternNew_456().find132pattern(new int[]{3, 1, 4, 2}));
    }
}

import java.util.*;

public class NextGreaterElementsNew_503 {
    // 循环数组中 找到下一个更大值
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        // 保存 nums 中比当前数字小的值
        Deque<Integer> stack = new LinkedList<>();

        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n - 1; i++) {
            // 就要弹出 说明当前这个 i % n 位置的数 比之前的都大 说明找到了第一个更大的数
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i % n]) {
                res[stack.removeLast()] = nums[i % n];
            }
            stack.addLast(i % n);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterElementsNew_503().nextGreaterElements(new int[]{1, 2, 1})));
    }
}

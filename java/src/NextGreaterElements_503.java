import java.util.*;

public class NextGreaterElements_503 {

    // 单调栈
    public int[] nextGreaterElements(int[] nums) {
        // 优化循环
        int n = nums.length;
        int[] res = new int[n];
        // 添加的默认值
        Arrays.fill(res, -1);
        // 单调栈保存 nums 中的下标
        Deque<Integer> stack = new LinkedList<>();
        // 因为是循环数组 所以遍历到最后一个的时候 还要看其左侧的
        // 所以相当于是两倍长度
        for (int i = 0; i < 2 * n - 1; i++) {
            // stack 里面放置的都是比 nums[i % n] 小的数 在其被弹出的时候 说明之后第一个比他大的数 就是访问的 nums[i % n]
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterElements_503().nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
    }
}

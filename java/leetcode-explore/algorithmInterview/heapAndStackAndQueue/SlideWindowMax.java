package algorithmInterview.heapAndStackAndQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlideWindowMax {

    // o(1) 获取栈最大值的数据结果
    static class MaxStack {
        Deque<Integer> stack;
        Deque<Integer> stackForMax;

        public MaxStack() {
            this.stack = new LinkedList<>();
            this.stackForMax = new LinkedList<>();
        }

        public void push(Integer num) {
            stack.push(num);
            if (stackForMax.size() == 0) {
                stackForMax.push(num);
            } else {
                if (stackForMax.peek() > num) {
                    stackForMax.push(stackForMax.peek());
                } else {
                    stackForMax.push(num);
                }
            }
        }

        public int pop() {
            if (stack.isEmpty()) return -1;
            stackForMax.pop();
            return stack.pop();
        }

        public int max() {
            if (!stackForMax.isEmpty()) return stackForMax.peek();
            // 表示不存在
            return -1;
        }

        public int size() {
            return stack.size();
        }
    }

    // 用双栈来模拟queue
    // 因为可以 o(1) 获取 stack 的最大值 因此这个也可以 o(1)
    static class MaxQueue {
        MaxStack stack1;
        MaxStack stack2;

        public MaxQueue() {
            this.stack1 = new MaxStack();
            this.stack2 = new MaxStack();
        }

        public void addLast(Integer num) {
            stack1.push(num);
        }
        public int removeFirst() {
            if (stack2.size() == 0) {
                while (stack1.size() > 0) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
        public int max() {
            return Math.max(stack1.max(), stack2.max());
        }
    }

    /**
     * 找到大小为 K 的滑动窗口在 nums 上的最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k > nums.length) return new int[]{};
        int[] res = new int[nums.length - k + 1];
        MaxQueue queue = new MaxQueue();
        int counter = 0;
        for (int i = 0; i < k; i++) {
            queue.addLast(nums[i]);
        }
        for (int i = k; i <= nums.length; i++) {
            res[counter++] = queue.max();
            if (i == nums.length) break;
            queue.removeFirst();
            queue.addLast(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SlideWindowMax().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}

import java.util.Deque;
import java.util.LinkedList;

public class ValidateStackSequences_31 {

    // 模拟栈操作
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0, j = 0; i < pushed.length; i++) {
            if (pushed[i] != popped[j]) {
                stack.add(pushed[i]);
                continue;
            }
            // 等于的话 就要弹出栈了
            // 弹出 popped
            j++;

            while (stack.size() > 0 && j < popped.length && stack.getLast() == popped[j]) {
                stack.removeLast();
                j++;
            }
        }
        return stack.isEmpty();
    }
}

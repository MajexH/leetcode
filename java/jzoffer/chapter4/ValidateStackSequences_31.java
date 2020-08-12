package chapter4;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateStackSequences_31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0, j = 0;

        while (i < pushed .length) {
            if (pushed[i] != popped[j]) {
                stack.push(pushed[i]);
            } else {
                stack.push(pushed[i]);
                while (stack.size() > 0 && j < pushed.length && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            }
            i++;
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new ValidateStackSequences_31().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }
}

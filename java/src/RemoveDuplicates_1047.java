import java.util.Deque;
import java.util.LinkedList;

public class RemoveDuplicates_1047 {

    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (stack.size() > 0 && c == stack.peekLast()) {
                stack.removeLast();
            } else {
                stack.add(c);
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.removeFirst());
        }
        return builder.toString();
    }
}

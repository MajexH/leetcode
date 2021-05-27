package WordSearch79;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseParentheses_1190 {

    // 反转 s 中 () 中的字符串
    public String reverseParentheses(String s) {
        Deque<StringBuilder> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                queue.add(new StringBuilder());
                continue;
            }
            if (c == ')') {
                // reverse
                assert !queue.isEmpty();
                StringBuilder b = queue.removeLast();
                if (queue.isEmpty()) {
                    queue.add(new StringBuilder());
                }
                queue.getLast().append(b.reverse());
                continue;
            }
            if (queue.isEmpty()) queue.add(new StringBuilder());
            queue.getLast().append(c);
        }
        return queue.removeLast().toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseParentheses_1190().reverseParentheses("vdgzyj()"));
    }
}

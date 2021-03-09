import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RemoveDuplicates {

    // 删除 s 中重复且相邻的字母
    // 重复删除 直到没有能够删除的
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (Character c : s.toCharArray()) {
            if (stack.size() > 0 && stack.peekLast() == c) {
                stack.removeLast();
            } else {
                stack.addLast(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (stack.size() > 0) {
            builder.append(stack.removeFirst());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates("abba"));
    }
}

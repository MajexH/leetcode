import java.util.LinkedList;

public class ValidBrackets {

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char character : s.toCharArray()) {
            if (character == '(' || character == '{' || character == '[')
                stack.addLast(character);
            else {
                if (stack.size() == 0) return false;
                else {
                    if (character == ')' && stack.peekLast() == '(') {
                        stack.removeLast();
                        continue;
                    }
                    if (character == ']' && stack.peekLast() == '[') {
                        stack.removeLast();
                        continue;
                    }
                    if (character == '}' && stack.peekLast() == '{') {
                        stack.removeLast();
                        continue;
                    }
                }

                return false;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new ValidBrackets().isValid("([)]"));
    }
}

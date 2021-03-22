import java.util.Deque;
import java.util.LinkedList;

public class EvalRPNNew_150 {

    private boolean isOperator(String token) {
        return token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-");
    }

    private int operate(String token, int n1, int n2) {
        switch (token) {
            case "+" -> {
                return n1 + n2;
            }
            case "-" -> {
                return n2 - n1;
            }
            case "/" -> {
                return n2 / n1;
            }
            default -> {
                return n2 * n1;
            }
        }
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();

        for (String token : tokens) {
            if (!isOperator(token)) {
                stack.addLast(Integer.parseInt(token));
                continue;
            }
            // 计算
            assert stack.size() >= 2;

            stack.add(operate(token, stack.removeLast(), stack.removeLast()));
        }

        return stack.removeLast();
    }
}

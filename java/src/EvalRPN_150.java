import java.util.Deque;
import java.util.LinkedList;

public class EvalRPN_150 {

    public int operate(String operator, int num1, int num2) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num2 - num1;
            case "*" -> num1 * num2;
            case "/" -> num2 / num1;
            default -> -1;
        };
    }

    public boolean isOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }

    // 逆波兰表达式求值
    public int evalRPN(String[] tokens) {
        Deque<Integer> nums = new LinkedList<>();

        for (String str : tokens) {
            if (!isOperator(str)) {
                nums.addLast(Integer.valueOf(str));
                continue;
            }
            assert nums.size() >= 2;
            nums.addLast(operate(str, nums.removeLast(), nums.removeLast()));
        }
        if (nums.size() != 1) return -1;
        return nums.removeLast();
    }
}

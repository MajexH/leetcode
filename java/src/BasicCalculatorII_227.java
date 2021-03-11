import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BasicCalculatorII_227 {

    private int operate(char operator, int n1, int n2) {
        return switch (operator) {
            case '+' -> n1 + n2;
            case '*' -> n1 * n2;
            case '/' -> n2 / n1;
            case '-' -> n2 - n1;
            default -> 0;
        };
    }

    private Character getOperator(String operator) {
        return switch (operator) {
            case "+" -> '+';
            case "*" -> '*';
            case "/" -> '/';
            case "-" -> '-';
            default -> ' ';
        };
    }

    // 栈顶的优先级大于现在的 需要弹出栈 返回 true
    // 相同优先级的也要弹出 如 top 是 + - now 是 + - top * / now * /
    private boolean cmpPriority(Character top, Character now) {
        // 说明栈顶的优先级大于 现在的 operator
        return (now == '+' || now == '-') || (top == '*' || top == '/' && (now == '*' || now == '/'));
    }

    private List<String> getStrs(String str) {
        List<String> strs = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                builder.append(c);
            } else {
                if (builder.length() > 0) {
                    strs.add(builder.toString());
                    builder.delete(0, builder.length());
                }
                if (c == '+' || c == '-' || c == '/' || c == '*') {
                    strs.add(String.valueOf(c));
                }
            }
        }
        if (builder.length() > 0) strs.add(builder.toString());
        return strs;
    }

    public int calculate(String s) {
        List<Integer> nums = new LinkedList<>();
        List<Character> operators = new LinkedList<>();

        // 简单 split 不行 还要读数字
        List<String> strs = getStrs(s.trim());

        for (String str : strs) {
            Character operator = getOperator(str);
            if (operator == ' ') {
                nums.add(Integer.parseInt(str));
                continue;
            }

            // 下面就要比较优先级了
            while (operators.size() > 0 && cmpPriority(operators.get(operators.size() - 1), operator)) {
                assert nums.size() >= 2;
                // 弹出栈
                nums.add(operate(operators.remove(operators.size() - 1), nums.remove(nums.size() - 1), nums.remove(nums.size() - 1)));
            }

            operators.add(operator);
        }
        while (operators.size() > 0) {
            nums.add(operate(operators.remove(operators.size() - 1), nums.remove(nums.size() - 1), nums.remove(nums.size() - 1)));
        }
        return nums.get(nums.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculatorII_227().calculate("3+2*2"));
        System.out.println(new BasicCalculatorII_227().calculate("  3/2  "));
        System.out.println(new BasicCalculatorII_227().calculate("  3 + 5 / 2"));
        System.out.println(new BasicCalculatorII_227().calculate("3*2 + 3"));
        System.out.println(new BasicCalculatorII_227().calculate("1 - 1 + 1"));
    }
}

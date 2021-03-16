import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator_224 {

    private int operate(char operator, int n1, int n2) {
        switch (operator) {
            case '+' -> {
                return n1 + n2;
            }
            case '-' -> {
                return n2 - n1;
            }
        }
        return 0;
    }

    // 字符的优先级！！！ TODO: 中值表达式 转 逆波兰表达式


    // 中缀转后缀
    public int calculate(String s) {
        // 只有 数字 + - ( )

        Deque<Integer> number = new LinkedList<>();
        Deque<Character> operators = new LinkedList<>();
        if (s.length() > 0 && s.charAt(0) == '-') {
            s = '0' + s;
        }

        s = s.replaceAll("\\(\\+", "(0+");
        s = s.replaceAll("\\(-", "(0-");
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);

            if (c == ' ') {
                i++;
            } else if (c == '+') {
                // 需要弹出栈 直到优先级相等 因为只有 - + 所以需要一直弹出到 -
                while (operators.size() > 0 && operators.peekLast() != '+' && operators.peekLast() != '(') {
                    int first = number.removeLast();
                    int second = 0;
                    if (!number.isEmpty()) second = number.removeLast();
                    number.add(operate(operators.removeLast(), first, second));
                }
                operators.add(c);
                i++;
            } else if (c == '-') {
                while (operators.size() > 0 && operators.peekLast() == '-' && operators.peekLast() != '(') {
                    int first = number.removeLast();
                    int second = 0;
                    if (!number.isEmpty()) second = number.removeLast();
                    number.add(operate(operators.removeLast(), first, second));
                }
                operators.add(c);
                i++;
            } else if (c == '(') {
                operators.add(c);
                i++;
            } else if (c == ')') {
                // 弹栈
                while (operators.size() > 0 && operators.peekLast() != '(') {
                    int first = number.removeLast();
                    int second = 0;
                    if (!number.isEmpty()) second = number.removeLast();
                    number.add(operate(operators.removeLast(), first, second));
                }
                // 去掉 (
                operators.removeLast();
                i++;
            } else {
                int num = 0;
                // 数字
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                number.add(num);
            }
        }

        while (!operators.isEmpty()) {
            int first = number.removeLast();
            int second = 0;
            if (!number.isEmpty()) second = number.removeLast();
            number.add(operate(operators.removeLast(), first, second));
        }
        return number.getLast();
    }


    public static void main(String[] args) {
        System.out.println(new BasicCalculator_224().calculate( "(6)-(8)-(7)+(1+(6))"));
        System.out.println(new BasicCalculator_224().calculate( "1 + 1"));
        System.out.println(new BasicCalculator_224().calculate( " 2-1 + 2 "));
        System.out.println(new BasicCalculator_224().calculate( "(1+(4+5+2)-3)+(6+8)"));
    }
}

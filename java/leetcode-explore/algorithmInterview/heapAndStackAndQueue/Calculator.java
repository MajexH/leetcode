package algorithmInterview.heapAndStackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class Calculator {

    public boolean cmpPriority(char a, char b) {
        // 前一个的优先级 小于 后一个
        if ((a == '+' || a == '-') && (b == '*' || b == '/')) {
            return false;
        } else {
            return (b == '+' || b == '-') && (a == '*' || a == '/');
        }
    }

    public int operate(int a, int b, char c) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                return b / a;
        }
        return 0;
    }

    public int calculate(String s) {
        if (s == null) return 0;
        Deque<Integer> integers = new LinkedList<>();
        Deque<Character> operators = new LinkedList<>();
        for (int i = 0; i < s.length();) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (c >= '0' && c <= '9') {
                // 可能有多个的 要组成一个字符
                int sum = 0;
                while (c >= '0' && c <= '9') {
                    sum = sum * 10 + c - '0';
                    i++;
                    if (i >= s.length()) break;
                    c = s.charAt(i);
                }
                integers.push(sum);
            } else {
                if (operators.size() == 0) {
                    operators.push(c);
                } else {
                    // 前一个的优先级大于后一个 说明 得进栈
                    if (cmpPriority(c, operators.peek())) {
                        operators.push(c);
                    } else {
                        // 说明得计算一个结果 直到栈顶的 operator 的优先级小于即可
                        while (operators.size() > 0 && !cmpPriority(c, operators.peek())) {
                            integers.push(operate(integers.pop(), integers.pop(), operators.pop()));
                        }
                        operators.push(c);
                    }
                }
                i++;
            }
        }
        while (operators.size() > 0) {
            assert integers.size() > 0;
            integers.push(operate(integers.pop(), integers.pop(), operators.pop()));
        }
        return integers.pop();
    }

    public static void main(String[] args) {
        System.out.println(new Calculator().calculate("3*2+2"));
    }
}

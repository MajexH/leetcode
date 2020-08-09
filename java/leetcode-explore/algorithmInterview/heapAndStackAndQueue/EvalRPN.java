package algorithmInterview.heapAndStackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class EvalRPN {

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

    public boolean isOperators(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null) return 0;
        Deque<Integer> integers = new LinkedList<>();
        for (String str : tokens) {
            if (str.length() == 1 && isOperators(str.charAt(0))) {
                assert integers.size() > 0;
                integers.push(operate(integers.pop(), integers.pop(), str.charAt(0)));
            } else {
                // 这个情况下就只有数字
                integers.push(Integer.parseInt(str));
            }
        }
        return integers.pop();
    }

    public static void main(String[] args) {
        System.out.println(new EvalRPN().evalRPN(new String[]{ "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));
    }
}

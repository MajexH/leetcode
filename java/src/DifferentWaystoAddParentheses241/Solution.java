package DifferentWaystoAddParentheses241;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> diffWaysToCompute(String input) {
        return recursion(input, 0, input.length());
    }

    public List<Integer> recursion(String input, int start, int end) {
        List<Integer> temp = new ArrayList<>();
        boolean isNumber = true;
        for (int i = start; i < end; i++) {
            char charactor = input.charAt(i);
            if (charactor == '-' || charactor == '+' || charactor == '*') {
                isNumber = false;
                List<Integer> lefts = recursion(input, start, i), rights = recursion(input, i + 1, end);
                for (Integer left : lefts) {
                    for (Integer right : rights) {
                        switch (charactor) {
                            case '-':
                                temp.add(left - right);
                                break;
                            case '+':
                                temp.add(left + right);
                                break;
                            case '*':
                                temp.add(left * right);
                                break;
                        }
                    }
                }
            }
        }
        if (isNumber) {
            temp.add(Integer.parseInt(input.substring(start, end)));
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().diffWaysToCompute("2*3-4*5"));
    }
}

//给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
//
// 有效的表达式需遵循以下约定： 
//
// 
// "t"，运算结果为 True 
// "f"，运算结果为 False 
// "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT） 
// "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND） 
// "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR） 
// 
//
// 
//
// 示例 1： 
//
// 输入：expression = "!(f)"
//输出：true
// 
//
// 示例 2： 
//
// 输入：expression = "|(f,t)"
//输出：true
// 
//
// 示例 3： 
//
// 输入：expression = "&(t,f)"
//输出：false
// 
//
// 示例 4： 
//
// 输入：expression = "|(&(t,f,t),!(t))"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 20000 
// expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。 
// expression 是以上述形式给出的有效表达式，表示一个布尔值。 
// 
//
// Related Topics 栈 递归 字符串 👍 119 👎 0


package leetcode.editor.cn;

import java.util.*;

public class ParsingABooleanExpression1106 {
    public static void main(String[] args) {
        Solution solution = new ParsingABooleanExpression1106().new Solution();
        System.out.println(solution.parseBoolExpr("!(f)"));
        System.out.println(solution.parseBoolExpr("|(f,t)"));
        System.out.println(solution.parseBoolExpr("&(t,f)"));
        System.out.println(solution.parseBoolExpr("|(&(t,f,t),!(t))"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        private static final Set<Character> OPERATORS = new HashSet<>();

        static {
            OPERATORS.add('!');
            OPERATORS.add('|');
            OPERATORS.add('&');
        }

        public boolean parseBoolExpr(String expression) {

            Deque<Boolean> values = new LinkedList<>();

            Deque<Character> operator = new LinkedList<>();

            for (int i = 0; i < expression.length(); i++) {

                char c = expression.charAt(i);

                if (OPERATORS.contains(c)) {
                    operator.addLast(expression.charAt(i));
                    continue;
                }

                if (c == ',') {
                    continue;
                }

                if (c == '(') {
                    // 新增一层
                    values.addLast(null);
                    continue;
                }

                // 计算当前栈的数据
                if (c == ')') {
                    List<Boolean> currentVals = new ArrayList<>();
                    while (!values.isEmpty() && values.peekLast() != null) {
                        currentVals.add(values.removeLast());
                    }

                    if (!values.isEmpty() && values.peekLast() == null) {
                        values.removeLast();
                    }
                    values.addLast(this.compute(operator.removeLast(),currentVals ));
                    continue;
                }

                // 只有一种可能了 现在 就是普通的数据
                values.addLast(this.parse(c));
            }

            return values.removeLast();
        }

        private boolean parse(char c) {
            if (c == 't') {
                return true;
            }
            return false;
        }

        private boolean compute(char operator, List<Boolean> values) {

            if (operator == '!') {
                return !values.get(0);
            }

            if (operator == '&') {
                boolean res = true;
                for (boolean value : values) {
                    res = res && value;
                }
                return res;
            }

            boolean res = false;
            for (boolean value : values) {
                res = res || value;
            }

            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
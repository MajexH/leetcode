//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数： 
//
// 
// () 得 1 分。 
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。 
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。 
// 
//
// 
//
// 示例 1： 
//
// 输入： "()"
//输出： 1
// 
//
// 示例 2： 
//
// 输入： "(())"
//输出： 2
// 
//
// 示例 3： 
//
// 输入： "()()"
//输出： 2
// 
//
// 示例 4： 
//
// 输入： "(()(()))"
//输出： 6
// 
//
// 
//
// 提示： 
//
// 
// S 是平衡括号字符串，且只含有 ( 和 ) 。 
// 2 <= S.length <= 50 
// 
//
// Related Topics 栈 字符串 👍 411 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class ScoreOfParentheses856 {
    public static void main(String[] args) {
        Solution solution = new ScoreOfParentheses856().new Solution();
        System.out.println(solution.scoreOfParentheses("()"));
        System.out.println(solution.scoreOfParentheses("(())"));
        System.out.println(solution.scoreOfParentheses("()()"));
        System.out.println(solution.scoreOfParentheses("(()(()))"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final class Pair {
            boolean isChar;
            int val;

            public Pair(boolean isChar, int val) {
                this.isChar = isChar;
                this.val = val;
            }
        }

        public int scoreOfParentheses(String s) {

            if (Objects.isNull(s) || s.length() == 0) {
                return 0;
            }

            Deque<Pair> stack = new LinkedList<>();

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.addLast(new Pair(true, c));
                    continue;
                }

                // 现在是 ) 就要弹栈
                if (stack.peekLast().isChar) {
                    stack.removeLast();
                    stack.addLast(new Pair(false, 1));
                    continue;
                }

                int res = 0;
                while (!stack.isEmpty() && !stack.peekLast().isChar) {
                    res += stack.removeLast().val;
                }
                stack.removeLast();
                stack.addLast(new Pair(false, res * 2));
            }

            int res = 0;
            while (!stack.isEmpty()) {
                res += stack.removeLast().val;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
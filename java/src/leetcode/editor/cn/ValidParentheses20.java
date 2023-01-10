//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3670 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses20 {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses20().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new LinkedList<>();

            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.addLast(c);
                } else if (c == ')') {
                    if (!stack.isEmpty() && stack.peekLast() == '(') {
                        stack.removeLast();
                        continue;
                    }
                    return false;
                } else if (c == '}') {
                    if (!stack.isEmpty() && stack.peekLast() == '{') {
                        stack.removeLast();
                        continue;
                    }
                    return false;
                } else if (c == ']') {
                    if (!stack.isEmpty() && stack.peekLast() == '[') {
                        stack.removeLast();
                        continue;
                    }
                    return false;
                }
            }

            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给你一个由 '('、')' 和小写字母组成的字符串 s。 
//
// 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。 
//
// 请返回任意一个合法字符串。 
//
// 有效「括号字符串」应当符合以下 任意一条 要求： 
//
// 
// 空字符串或只包含小写字母的字符串 
// 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」 
// 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "lee(t(c)o)de)"
//输出："lee(t(c)o)de"
//解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "a)b(c)d"
//输出："ab(c)d"
// 
//
// 示例 3： 
//
// 
//输入：s = "))(("
//输出：""
//解释：空字符串也是有效的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 可能是 '('、')' 或英文小写字母 
// 
//
// Related Topics 栈 字符串 👍 212 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MinimumRemoveToMakeValidParentheses1249 {
    public static void main(String[] args) {
        Solution solution = new MinimumRemoveToMakeValidParentheses1249().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minRemoveToMakeValid(String s) {

            Deque<Integer> leftIndexes = new LinkedList<>();

            Set<Integer> needRemoveIndexes = new HashSet<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(') {
                    leftIndexes.addLast(i);
                } else if (c == ')') {
                    if (!leftIndexes.isEmpty()) {
                        leftIndexes.removeLast();
                        continue;
                    }
                    needRemoveIndexes.add(i);
                }
            }

            StringBuilder res = new StringBuilder();

            // 剩下的左括号也要删除
            needRemoveIndexes.addAll(leftIndexes);

            for (int i = 0; i < s.length(); i++) {

                if (needRemoveIndexes.contains(i)) {
                    continue;
                }
                res.append(s.charAt(i));
            }

            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
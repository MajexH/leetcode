package leetcode.editor.cn;//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2686 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private void recursion(int left, int right, List<String> res, StringBuilder tmp) {
        if (left == 0 && right == 0) {
            res.add(tmp.toString());
            return;
        }
        if (left < 0 || right < 0) {
            return;
        }

        tmp.append('(');
        recursion(left - 1, right, res, tmp);
        tmp.deleteCharAt(tmp.length() - 1);

        if (right > left) {
            tmp.append(')');
            recursion(left, right - 1, res, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursion(n, n, res, new StringBuilder());
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

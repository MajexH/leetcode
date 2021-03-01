package highFrequency.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {

    // 输入可能包含了除 ( 和 ) 以外的字符
    // 删除其中的的无用的括号
    // 返回使其成立的括号的所有解
    public List<String> removeInvalidParenthesesExample(String s) {
        // 统计多余的括号数量
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left == 0) {
                    right++;
                }
                // 已经有左括号 可以匹配
                if (left > 0) {
                    left--;
                }
            }
        }

        // 尝试每一种删除的方法 会得到什么结果
        Set<String> validParentheses = new HashSet<>();
        dfsExample(validParentheses, s, new StringBuilder(), 0, left, right, 0, 0);
        return new ArrayList<>(validParentheses);
    }

    // 实际上这道题最后就演变为 这个地方的这个 ( ) 删除不删除
    public List<String> removeInvalid(String s) {
        // 统计多余的括号数量
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left == 0) {
                    right++;
                }
                // 已经有左括号 可以匹配
                if (left > 0) {
                    left--;
                }
            }
        }
        // 尝试每一种删除的方法 会得到什么结果
        Set<String> validParentheses = new HashSet<>();
        dfs(validParentheses, s, 0, left, right);
        return new ArrayList<>(validParentheses);
    }

    // 遍历所有的可能 这个地方的删除不删除
    public void dfs(Set<String> validParentheses, String s, int index, int leftRemove, int rightRemove) {
        if (leftRemove == 0 && rightRemove == 0) {
            if (valid(s)) validParentheses.add(s);
            return;
        }
        // 遍历节点 删除不删除
        // 带动节点移动
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            String s1 = s.substring(0, i) + s.substring(i + 1);
            if (leftRemove > 0 && c == '(') {
                // 可以删除左括号
                // 因为删除了一个 index 所以不便
                dfs(validParentheses, s1, i, leftRemove - 1, rightRemove);
            }
            if (rightRemove > 0 && c == ')') {
                dfs(validParentheses, s1, i, leftRemove, rightRemove - 1);
            }
        }

    }

    public boolean valid(String s) {
        int left = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                // 不能减少了
                if (left == 0) {
                    return false;
                }
                left--;
            }
        }
        return true;
    }

    // 根据 leftRemove rightRemove 去遍历删除 针对每一个位置的情况 有两种可能
    // 一种是保留 一种是删除
    // left, right 表示已经加入的 left right 括号数量
    public void dfsExample(Set<String> validParentheses, String s, StringBuilder path, int index, int leftRemove, int rightRemove, int left, int right) {
        if (index == s.length()) {
            // 有效的结果
            if (leftRemove == 0 && rightRemove == 0) {
                validParentheses.add(path.toString());
            }
            return;
        }
        char c = s.charAt(index);
        // 表示可以删除这个 ( 试试
        if (c == '(' && leftRemove > 0) {
            dfsExample(validParentheses, s, path, index + 1, leftRemove - 1, rightRemove, left, right);
        }
        if (c == ')' && rightRemove > 0) {
            dfsExample(validParentheses, s, path, index + 1, leftRemove, rightRemove - 1, left, right);
        }

        // 可以加入字符
        // 下面再剪枝
        path.append(c);
        if (c != '(' && c != ')') {
            // 不是 ( ) 可以直接接入结果
            dfsExample(validParentheses, s, path, index + 1, leftRemove, rightRemove, left, right);
        } else if (c == '(') {
            // 左括号 这个时候这个左括号是没办法匹配的 所有 leftRemove + 1
            dfsExample(validParentheses, s, path, index + 1, leftRemove, rightRemove, left + 1, right);
        } else if (left > right) {
            // 只有当左边已经匹配了多余的 left 后 才可以匹配 多余的 right
            dfsExample(validParentheses, s, path, index + 1, leftRemove, rightRemove, left, right + 1);
        }
        path.deleteCharAt(path.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new RemoveInvalidParentheses().removeInvalid("()())()"));
    }
}

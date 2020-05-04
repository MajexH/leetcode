import java.util.LinkedList;

public class LongestValidParentheses_32 {
    public int longestValidParentheses(String s) {
        // stack 表示s里面的位置 不过保存的是当前 合理字符串 的开始位置（因为这样在碰到右括号的时候 可以直接拿到长度）
        LinkedList<Integer> stack = new LinkedList<>();
        int maxLength = Integer.MIN_VALUE;
        stack.add(-1);
        for (int i = 0; i < s.length(); i++) {
            // 遇到左括号
            if (s.charAt(i) == '(') {
                stack.add(i);
            } else {
                stack.removeLast();
                // 这个时候空了 说明现在这个 ) 取代上个 ） 成为最左边的右括号
                if (stack.isEmpty()) {
                    stack.add(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peekLast());
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses_32().longestValidParentheses("(()"));
    }
}

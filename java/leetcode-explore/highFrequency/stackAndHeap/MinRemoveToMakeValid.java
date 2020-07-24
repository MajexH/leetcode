package highFrequency.stackAndHeap;

import java.util.Deque;
import java.util.LinkedList;

public class MinRemoveToMakeValid {

    /**
     * 给你一个由 '('、')' 和小写字母组成的字符串 s。
     *
     * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
     *
     * 请返回任意一个合法字符串。
     *
     * 有效「括号字符串」应当符合以下 任意一条 要求：
     *
     * 空字符串或只包含小写字母的字符串
     * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
     * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
     * @param s
     * @return
     */
    public String minRemoveToMakeValid(String s) {
        // 标识 s 字符串中下标为 i 的地方是否是合法的
        boolean[] validPattern = new boolean[s.length()];
        char[] origin = s.toCharArray();
        // 这个里面只放左括号的下标
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < origin.length; i++) {
            if (origin[i] == '(') {
                // 第一次加入左括号必定是不合法的
                // 因为不知道后面有没有右括号 跟他匹配
                stack.add(i);
                validPattern[i] = false;
            } else if (origin[i] == ')') {
                if (stack.size() == 0)
                    // 没有左括号匹配
                    validPattern[i] = false;
                else {
                    // 找到右括号跟之前的匹配 就删除一个
                    validPattern[stack.removeLast()] = true;
                    validPattern[i] = true;
                }
            } else {
                validPattern[i] = true;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < origin.length; i++) {
            if (validPattern[i]) builder.append(origin[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MinRemoveToMakeValid().minRemoveToMakeValid("(a(b(c)d)"));
    }
}

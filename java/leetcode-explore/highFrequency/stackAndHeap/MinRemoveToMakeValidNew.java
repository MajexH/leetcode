package highFrequency.stackAndHeap;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MinRemoveToMakeValidNew {

    // 从 s 中删除最少数目的 ( or ) 使得 s 中 () 是有效的
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> indexes = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                indexes.addLast(i);
            } else if (s.charAt(i) == ')') {
                if (!indexes.isEmpty() && s.charAt(indexes.peekLast()) == '(') {
                    indexes.removeLast();
                } else {
                    indexes.addLast(i);
                }
            }
        }

        // 剩下在 indexes 中的 都是要删除的
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexes.isEmpty() && indexes.peekFirst() == i) {
                indexes.removeFirst();
                continue;
            }
           builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MinRemoveToMakeValidNew().minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(new MinRemoveToMakeValidNew().minRemoveToMakeValid("a)b(c)d"));
        System.out.println(new MinRemoveToMakeValidNew().minRemoveToMakeValid("))(("));
        System.out.println(new MinRemoveToMakeValidNew().minRemoveToMakeValid("(a(b(c)d)"));
    }
}

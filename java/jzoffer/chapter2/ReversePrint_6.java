package chapter2;

import java.util.LinkedList;

public class ReversePrint_6 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }

        int[] res = new int[stack.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }

        return res;
    }
}

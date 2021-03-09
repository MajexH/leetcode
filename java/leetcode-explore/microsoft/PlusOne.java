package microsoft;

import java.util.Deque;
import java.util.LinkedList;

public class PlusOne {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // list 表示的数字加一
    // 高位在链表头部 低位在尾部
    public ListNode plusOne(ListNode head) {
        int add = 1;
        ListNode rem = head;
        Deque<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.addLast(head);
            head = head.next;
        }

        while (stack.size() > 0 && add != 0) {
            ListNode last = stack.removeLast();
            last.val = last.val + add;
            add = last.val / 10;
            last.val %= 10;
        }

        if (stack.size() == 0 && add != 0) {
            ListNode newHead = new ListNode(add);
            newHead.next = rem;
            return newHead;
        }
        return rem;
    }
}

package chapter3;

public class ReverseList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode next = head.next;
        while (head != null) {
            head.next = pre;
            pre = head;
            head = next;
            if (next != null)
                next = next.next;
        }
        return pre;
    }
}

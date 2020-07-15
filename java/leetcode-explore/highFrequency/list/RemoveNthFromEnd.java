package highFrequency.list;

public class RemoveNthFromEnd {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(1), remember = pre;
        pre.next = head;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            pre = pre.next;
            fast = fast.next;
        }
        assert pre.next != null;
        pre.next = pre.next.next;
        return remember.next;
    }
}

public class DeleteNthNodeFromEnd {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode remember = new ListNode(1), move = remember;
        remember.next = head;
        ListNode pre = remember, fast = remember.next;
        while (n > 0) {
            // 说明删除的节点比原来的链表长
            if (fast == null) return head;
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            fast = fast.next;
            pre = pre.next;
        }
        assert pre.next != null;
        pre.next = pre.next.next;

        return remember.next;
    }
}

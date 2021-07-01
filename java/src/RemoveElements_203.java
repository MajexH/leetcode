public class RemoveElements_203 {
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

    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(1);
        pre.next = head;
        ListNode rem = pre;
        while (head != null) {
            while (head != null && head.val == val) {
                head = head.next;
            }
            pre.next = head;
            pre = pre.next;
            if (head != null) head = head.next;
        }
        return rem.next;
    }
}

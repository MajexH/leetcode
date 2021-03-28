public class RotateRightNew_61 {
    public static class ListNode {
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int len = getListLen(head);
        k = k % len;

        int mov = len - k;

        ListNode preHead = new ListNode(1), tail = null, rem = head;
        preHead.next = head;
        while (head != null) {
            if (head.next == null) tail = head;
            if (mov > 0) {
                mov--;
                preHead = preHead.next;
            }
            head = head.next;
        }
        assert preHead != null;
        ListNode newHead = preHead.next;
        if (newHead == null) return rem;
        preHead.next = null;
        tail.next = rem;
        return newHead;
    }

    public int getListLen(ListNode node) {
        int res = 0;
        while (node != null) {
            node = node.next;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        System.out.println(new RotateRightNew_61().rotateRight(a, 3));
    }
}

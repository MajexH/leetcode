package tencent.list;

public class RotateRight {

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
        if (head == null) return null;
        int len = getListLength(head);
        k = len - k % len;

        ListNode pre = new ListNode(1);
        pre.next = head;
        ListNode mv = head;
        while (k > 0) {
            k--;
            pre = pre.next;
            mv = mv.next;
        }
        if (mv == null) return head;
        pre.next = null;
        ListNode newHead = mv;
        while (mv.next != null) {
            mv = mv.next;
        }
        mv.next = head;
        return newHead;
    }

    public int getListLength(ListNode node) {
        int res = 0;
        while (node != null) {
            res++;
            node = node.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
//        a.next = new ListNode(2);
//        a.next.next = new ListNode(3);
//        a.next.next.next = new ListNode(4);
//        a.next.next.next.next = new ListNode(5);
        System.out.println(new RotateRight().rotateRight(a, 1));
    }
}

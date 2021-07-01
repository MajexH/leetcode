package chapter3;

public class GetKthFromEnd_New_22 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head, last = head;

        while (k > 0) {
            k--;
            last = last.next;
        }

        while (last != null) {
            pre = pre.next;
            last = last.next;
        }
        return pre;
    }
}

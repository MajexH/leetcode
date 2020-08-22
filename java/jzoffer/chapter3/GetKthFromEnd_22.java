package chapter3;

public class GetKthFromEnd_22 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode fast = head;
        while (k > 0) {
            if (fast == null) return null;
            fast = fast.next;
            k--;
        }
        ListNode last = head;
        while (fast != null) {
            last = last.next;
            fast = fast.next;
        }
        return last;
    }
}

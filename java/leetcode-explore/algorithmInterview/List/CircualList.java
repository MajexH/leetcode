package algorithmInterview.List;

public class CircualList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode fast = head.next, last = head;

        while (fast != last) {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            last = last.next;
        }
        return true;
    }
}

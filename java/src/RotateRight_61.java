public class RotateRight_61 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int length(ListNode head) {
        int counter = 0;
        while (head != null) {
            counter++;
            head = head.next;
        }
        return counter;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        k = k % length(head);
        ListNode pre = new ListNode(1), last = head, fast = head;
        pre.next = head;
        // 记录 head 的尾结点
        ListNode recordTail = null;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            if (fast.next == null) recordTail = fast;
            fast = fast.next;
            pre = pre.next;
            last = last.next;
        }
        pre.next = null;
        assert recordTail != null;
        // last 为 null 说明要把null 放到 head之前 直接返回head即可
        if (last == null) return head;
        recordTail.next = head;
        return last;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
//        node.next = new ListNode(1);
//        node.next.next = new ListNode(2);
        System.out.println(new RotateRight_61().rotateRight(node, 1));
    }
}

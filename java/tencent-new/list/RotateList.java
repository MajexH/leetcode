package list;

public class RotateList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode slow = new ListNode(1), fast = head;
        slow.next = head;

        for (int counter = 0; counter < k; counter++) {
            fast = fast.next;
            if (fast == null) fast = head;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode temp = slow.next, res = temp;
        // 有可能要旋转的位置 就在最后一个
        if (temp == null) return head;
        slow.next = null;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return res;
    }
}

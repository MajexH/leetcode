package ListAndTreeNew;

import java.util.List;

public class DetectCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head.next, last = head;

        // 确认成环
        while (fast != last) {
            // 说明没环
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            last = last.next;
        }

        // 找到成环的长度
        int length = 1;
        last = last.next;
        while (last != fast) {
            last = last.next;
            length++;
        }

        // 找到第一个环点
        fast = head;
        while (length > 0) {
            fast = fast.next;
            length--;
        }
        last = head;
        while (fast != last) {
            fast = fast.next;
            last = last.next;
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        root.next = new ListNode(2);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(-4);
        root.next.next.next.next = root.next;
        System.out.println(new DetectCycle().detectCycle(root));
    }
}

package ListAndTree;

public class CycleList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head.next, last = head;
        while (fast != last) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            last = last.next;
        }

        int counter = 1;
        fast = last.next;
        while (fast != last) {
            counter++;
            fast = fast.next;
        }

        fast = head;
        last = head;
        while (counter > 0) {
            fast = fast.next;
            counter--;
        }
        while (fast != last) {
            fast = fast.next;
            last = last.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node.next = node2;
        node.next.next = node;
//        node.next.next = new ListNode(0);
//        node.next.next.next = new ListNode(-4);
//        node.next.next.next.next = node2;
        System.out.println(new CycleList().detectCycle(node));
    }
}

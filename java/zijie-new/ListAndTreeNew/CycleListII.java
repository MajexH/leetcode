package ListAndTreeNew;

public class CycleListII {

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
        // 检测成环
        ListNode slow = new ListNode(1), fast = head;
        slow.next = fast;
        while (fast != null && fast.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null || fast.next == null) return null;
        // 出来之后 一定是成环的
        int counter = 1;
        fast = fast.next;
        while (slow != fast) {
            fast = fast.next;
            counter++;
        }
        fast = head;
        slow = head;
        while (counter >= 0) {
            fast = fast.next;
            counter--;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        System.out.println(new CycleListII().detectCycle(new ListNode(1)));
    }
}

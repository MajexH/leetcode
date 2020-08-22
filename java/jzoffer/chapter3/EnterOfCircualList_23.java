package chapter3;

public class EnterOfCircualList_23 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getEnterNodeOfCricualList(ListNode head) {
        if (head == null || head.next == null) return null;
        // 确定存在环
        ListNode last = head, fast = head.next;
        while (last != fast) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            last = last.next;
        }
        // 存在环
        fast = fast.next;
        int counter = 1;
        while (last != fast) {
            fast = fast.next;
            counter++;
        }
        fast = head;
        while (counter > 0) {
            fast = fast.next;
            counter--;
        }
        last = head;
        while (last != fast)  {
            last = last.next;
            fast = fast.next;
        }
        return last;
    }
}

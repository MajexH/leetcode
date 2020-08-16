package chapter5;

public class IntersectionNode_52 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = length(headA), lengthB = length(headB);
        if (lengthB > lengthA) return getIntersectionNode(headB, headA);

        int diff = lengthA - lengthB;
        while (diff > 0) {
            diff--;
            headA = headA.next;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}

package algorithmInterview.List;

public class IntersectionNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode getInterNode(ListNode headA, ListNode headB, int lengthA, int lengthB) {
        int diff = lengthA - lengthB;
        while (diff > 0) {
            headA = headA.next;
            diff--;
        }
        while (headA != headB) {
            if (headA == null || headB == null) return null;
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }


    public int getLength(ListNode head) {
        int counter = 0;
        while (head != null) {
            counter++;
            head = head.next;
        }
        return counter;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA), lengthB = getLength(headB);
        if (lengthA > lengthB) return getInterNode(headA, headB, lengthA, lengthB);
        else return getInterNode(headB, headA, lengthB, lengthA);
    }
}

package ListAndTree;

import java.util.LinkedList;

public class MeetedList {


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        LinkedList<ListNode> aStack = new LinkedList<>();
        LinkedList<ListNode> bStack = new LinkedList<>();
        while (headA != null) {
            aStack.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            bStack.add(headB);
            headB = headB.next;
        }
        ListNode res = null;
        while (aStack.size() != 0 && bStack.size() != 0) {
            ListNode temp = aStack.removeLast();
            if (temp == bStack.removeLast()) {
                res = temp;
            } else {
                break;
            }
        }
        return res;
    }
}

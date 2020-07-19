package ListAndTreeNew;

public class InterSectionNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private int getLengthOfNode(ListNode node) {
        int counter = 0;
        while (node != null) {
            node = node.next;
            counter++;
        }
        return counter;
    }

    private ListNode getInter(ListNode longer, ListNode shorter, int longerLength, int shorterLength) {
        int diff = longerLength - shorterLength;
        while (diff > 0) {
            longer = longer.next;
            diff--;
        }
        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }
        return longer;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLengthOfNode(headA);
        int lengthB = getLengthOfNode(headB);

        return lengthA > lengthB ? getInter(headA, headB, lengthA, lengthB) : getInter(headB, headA, lengthB, lengthA);
    }
}

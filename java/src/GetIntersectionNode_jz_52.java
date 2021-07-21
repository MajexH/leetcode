public class GetIntersectionNode_jz_52 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getLen(headA), len2 = getLen(headB);
        if (len1 < len2) return getIntersectionNode(headB, headA, len2, len1);
        return getIntersectionNode(headA, headB, len1, len2);
    }

    private ListNode getIntersectionNode(ListNode node1, ListNode node2, int len1, int len2) {
        int diff = len1 - len2;

        while (diff > 0) {
            diff--;
            node1 = node1.next;
        }

        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    private int getLen(ListNode node) {
        int res = 0;
        while (node != null) {
            res++;
            node = node.next;
        }
        return res;
    }
}

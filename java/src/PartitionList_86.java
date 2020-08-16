public class PartitionList_86 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(1), moveL = left;
        ListNode right = new ListNode(1), moveR = right;

        while (head != null) {
            if (head.val >= x) {
                moveR.next = head;
                moveR = moveR.next;
            } else {
                moveL.next = head;
                moveL = moveL.next;
            }
            head = head.next;
        }

        moveL.next = right.next;
        moveR.next = null;
        return left.next;
    }
}

package chapter3;

public class MergetTwoList_25 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(1), mov = res;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                mov.next = l2;
                l2 = l2.next;
            } else {
                mov.next = l1;
                l1 = l1.next;
            }
            mov = mov.next;
        }
        if (l1 != null) {
            mov.next = l1;
        }
        if (l2 != null) {
            mov.next = l2;
        }
        return res.next;
    }
}

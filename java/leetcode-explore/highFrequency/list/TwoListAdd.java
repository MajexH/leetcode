package highFrequency.list;

public class TwoListAdd {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode mv = new ListNode(1), remember = mv;
        int add = 0;
        while (l1 != null && l2 != null) {
            l1.val = l1.val + l2.val + add;
            add = l1.val / 10;
            l1.val = l1.val % 10;
            mv.next = l1;
            mv = mv.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            l1.val += add;
            add = l1.val / 10;
            l1.val = l1.val % 10;
            mv.next = l1;
            mv = mv.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            l2.val += add;
            add = l2.val / 10;
            l2.val = l2.val % 10;
            mv.next = l2;
            mv = mv.next;
            l2 = l2.next;
        }
        if (add != 0) mv.next = new ListNode(add);
        return remember.next;
    }
}

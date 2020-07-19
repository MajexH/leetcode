package ListAndTreeNew;

public class AddTwoList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(1), move = res;

        int add = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            int sum = num1 + num2 + add;
            add = sum / 10;
            move.next = new ListNode(sum % 10);
            move = move.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (add != 0)
            move.next = new ListNode(add);

        return res.next;
    }
}

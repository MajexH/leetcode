package ListAndTree;

import java.util.List;

public class AddTwoList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode res = null, remember = null;
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + add;
            add = temp / 10;
            if (res == null) {
                res = new ListNode(temp % 10);
                remember = res;
            }
            else {
                res.next = new ListNode(temp % 10);
                res = res.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int temp = l1.val + add;
            add = temp / 10;
            if (res == null) {
                res = new ListNode(temp % 10);
                remember = res;
            }
            else {
                res.next = new ListNode(temp % 10);
                res = res.next;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            int temp = l2.val + add;
            add = temp / 10;
            if (res == null) {
                res = new ListNode(temp % 10);
                remember = res;
            }
            else {
                res.next = new ListNode(temp % 10);
                res = res.next;
            }
            l2 = l2.next;
        }
        if (add != 0) {
            res.next = new ListNode(add % 10);
        }
        return remember;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(new AddTwoList().addTwoNumbers(l1, l2));
    }
}

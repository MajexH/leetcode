package algorithmInterview.List;

import java.util.List;

public class OddEvenList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(1), even = new ListNode(2);
        ListNode moveOdd = odd, moveEven = even;
        while (head != null) {
            moveOdd.next = head;
            head = head.next;
            moveEven.next = head;
            moveOdd = moveOdd.next;
            moveEven = moveEven.next;
            if (head == null) break;
            head = head.next;
        }
        moveOdd.next = even.next;
        return odd.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(new OddEvenList().oddEvenList(head));
    }
}

package algorithmInterview.List;

public class OddEvenListNew {
    public class ListNode {
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
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(1), even = new ListNode(1);
        ListNode mvOdd = odd, mvEven = even;
        while (head != null) {
            mvOdd.next = head;
            head = head.next;
            mvOdd = mvOdd.next;
            if (head == null) {
                break;
            }
            mvEven.next = head;
            head = head.next;
            mvEven = mvEven.next;
        }
        mvEven.next = null;
        mvOdd.next = even.next;
        return odd.next;
    }
}

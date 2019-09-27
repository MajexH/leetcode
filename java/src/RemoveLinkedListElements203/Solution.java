package RemoveLinkedListElements203;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode record = new ListNode(0), pre = record;
        pre.next = head;
        while (head != null) {
            if (head.val == val) {
                while (head != null && head.val == val)
                    head = head.next;
                pre.next = head;
            }
            if (head == null) break;
            pre = pre.next;
            head = head.next;
        }
        return record.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next = new ListNode(6);
        System.out.println(new Solution().removeElements(node, 6));
    }
}

public class DeleteDuplicates_82_new {

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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(1);
        pre.next = head;
        ListNode rem = pre;

        while (head != null) {
            while (head != null && head.val == pre.next.val) {
                head = head.next;
            }
            if (pre.next.next == head) {
                pre = pre.next;
            } else {
                pre.next = head;
            }
        }

        return rem.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);
        System.out.println(new DeleteDuplicates_82_new().deleteDuplicates(node));
    }
}

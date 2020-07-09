public class RemoveLinkedListElements_203 {

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

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode pre = new ListNode(1), remember = pre;
        pre.next = head;

        while (head != null) {
            if (head.val == val) {
                if (head.next != null) {
                    head.val = head.next.val;
                    head.next = head.next.next;
                    // 因为是把后一个数的值 copy 到前一个位置来 因此pre head 均不变
                    continue;
                } else {
                    pre.next = null;
                }
            }
            head = head.next;
            pre = pre.next;
        }
        return remember.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);

        System.out.println(new RemoveLinkedListElements_203().removeElements(node, 1));
    }
}

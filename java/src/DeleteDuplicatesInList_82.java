public class DeleteDuplicatesInList_82 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(1), rem = pre;
        pre.next = head;

        while (head != null) {
            while (head.next != null && head.next.val == head.val) {
                head = head.next;
            }
            // 说明没有重复
            if (pre.next == head) {
                pre = head;
                head = head.next;
            } else {
                pre.next = head.next;
                head = pre.next;
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
        node.next.next.next.next.next.next.next = new ListNode(5);
        System.out.println(new DeleteDuplicatesInList_82().deleteDuplicates(node));
    }
}

public class DeleteDuplicates_83 {

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

    public ListNode deleteDuplicates(ListNode head) {
        // 排序链表中删除重复元素 只保留一个
        ListNode pre = new ListNode(1);
        pre.next = head;

        ListNode rem = pre;

        while (head != null) {
            while (head != null && head.val == pre.next.val) {
                head = head.next;
            }
            if (pre.next.next != head) {
                // 说明存在重复 需要删除后保留一个重复
                pre.next.next = head;
            }
            pre = pre.next;
        }

        return rem.next;
    }
}

public class DeleteDuplicates_82 {
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
        // 删除所有重复的节点

        ListNode rem = pre;

        while (head != null) {
            // 这儿是跳过重复的节点 但是需要知道的是 重复有几个 重复一个是不计算的
            while (head != null && head.val == pre.next.val) {
                head = head.next;
            }

            // 说明只有一个重复节点
            if (pre.next.next == head) {
                pre = pre.next;
            } else {
                // 现在 head 指向了一个不同的节点
                pre.next = head;
            }
        }

        return rem.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(3);
        a.next.next.next.next = new ListNode(4);
        a.next.next.next.next.next = new ListNode(4);
        a.next.next.next.next.next.next = new ListNode(5);

        System.out.println(new DeleteDuplicates_82().deleteDuplicates(a));
    }
}

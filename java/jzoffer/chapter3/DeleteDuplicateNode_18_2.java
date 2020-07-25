package chapter3;

public class DeleteDuplicateNode_18_2 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * 在一个排序的链表中删除所有重复出现的节点
     * 比如 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5 删除之后会是
     * 1 -> 2 -> 5
     * @param head
     */
    public ListNode deleteDuplicateNode(ListNode head) {
        if (head == null) return null;
        // 因为是排序的所以这样初始化
        ListNode pre = new ListNode(head.val - 1), remember = pre;
        pre.next = head;
        // 外层循环是遍历整个 list
        while (head != null) {
            // 这儿循环是为了防止出现 3 -> 3 -> 4 -> 4 这种连续相等的情况
            while (head != null && head.next != null && head.val == head.next.val) {
                // 这儿是为了找到跳过 3 -> 3 这种情况
                while (head.next != null && head.val == head.next.val) {
                    // 这个循环能够找到相等的数
                    head = head.next;
                }
                // 这样才能跳过一段重复
                head = head.next;
            }
            pre.next = head;
            pre = pre.next;
            if (head != null)
                head = head.next;
        }
        return remember.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(3);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);

        System.out.println(new DeleteDuplicateNode_18_2().deleteDuplicateNode(node));
    }
}

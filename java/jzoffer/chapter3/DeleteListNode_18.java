package chapter3;

public class DeleteListNode_18 {

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
     * 从 head 的一个链表中 o(1) 的删除 node 节点
     * @param head
     * @param node
     */
    public ListNode deleteNode(ListNode head, ListNode node) {
        if (node == null) return head;
        if (node.next == null) {
            // 只能从前向后找 删除尾结点
            // 这个时候可能删除的是头结点 因此新建一个头结点 防止删除的是头节点没法处理
            // java 是没法删除头结点的 因为这个无法改变外面的head指针的指向
            // 因此需要返回 head
            ListNode pre = new ListNode(1);
            pre.next = head;
            while (head != node) {
                pre = pre.next;
                head = head.next;
            }
            pre.next = head.next;
            return pre.next;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node = new DeleteListNode_18().deleteNode(node, node);
        System.out.println(node);
    }
}

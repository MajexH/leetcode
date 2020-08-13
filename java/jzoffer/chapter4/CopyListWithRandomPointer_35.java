package chapter4;

public class CopyListWithRandomPointer_35 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node rem = head;
        // 复制链表节点 接在原来的链表上
        while (head != null) {
            Node temp = new Node(head.val);
            temp.next = head.next;
            head.next = temp;
            head = temp.next;
        }
        head = rem;
        // copy random 节点
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        head = rem;
        // 构建结果
        Node res = new Node(1), mov = res;
        while (head != null) {
            mov.next = head.next;
            mov = mov.next;
            head.next = head.next.next;
            head = head.next;
        }
        return res.next;
    }
}

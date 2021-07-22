public class CopyRandomList_138 {

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

        Node mv = head;
        // 1 生成新的节点
        while (mv != null) {
            Node tmp = new Node(mv.val);
            tmp.next = mv.next;
            mv.next = tmp;
            mv = tmp.next;
        }

        // 2 random
        mv = head;
        while (mv != null) {
            if (mv.random != null) mv.next.random = mv.random.next;
            mv = mv.next.next;
        }
        Node rem = new Node(1);
        mv = rem;
        // 3 重新连接
        while (head != null) {
            mv.next = head.next;
            mv = mv.next;
            head.next = head.next.next;
            head = head.next;
        }

        return rem.next;
    }
}

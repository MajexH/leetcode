public class CopyRandomList_35 {

    static class Node {
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

        // 复制next
        while (mv != null) {
            Node tmp = new Node(mv.val);
            tmp.next = mv.next;
            mv.next = tmp;
            mv = tmp.next;
        }
        mv = head;
        // 复制 random
        while (mv != null) {
            if (mv.random != null) mv.next.random = mv.random.next;
            mv = mv.next.next;
        }

        Node returnVal = new Node(1), move = returnVal;
        mv = head;
        // 摘下来
        // 同时恢复原状
        while (mv != null) {
            move.next = mv.next;
            mv.next = mv.next.next;
            mv = mv.next;
            move = move.next;
        }
        return returnVal.next;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        a.next = new Node(2);
        a.next.random = a.next;
        System.out.println(new CopyRandomList_35().copyRandomList(a));
    }
}

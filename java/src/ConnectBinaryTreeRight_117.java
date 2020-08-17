import java.util.Deque;
import java.util.LinkedList;

public class ConnectBinaryTreeRight_117 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null) return null;
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node pre = null;
        while (!queue.isEmpty()) {
            Node top = queue.removeFirst();
            if (top == null) {
                if (queue.isEmpty()) break;
                queue.add(null);
                pre = null;
                continue;
            }
            if (top.left != null) queue.add(top.left);
            if (top.right != null) queue.add(top.right);
            if (pre == null) pre = top;
            else {
                pre.next = top;
                pre = pre.next;
            }
        }
        return root;
    }
}

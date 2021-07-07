public class TreeToDoublyList_36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public void recursion(Node node) {
        if (node == null) return;
        recursion(node.left);
        recursion(node.right);

        // 后续遍历 那么就要跟左子树的最右子树 连接
        Node left = node.left;
        if (left != null) {
            while (left.right != null) {
                left = left.right;
            }
            left.right = node;
            node.left = left;
        }

        Node right = node.right;
        if (right != null) {
            while (right.left != null) {
                right = right.left;
            }
            node.right = right;
            right.left = node;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        recursion(root);
        Node head = root;
        while (head.left != null) {
            head = head.left;
        }

        Node tail = root;
        while (tail.right != null) {
            tail = tail.right;
        }

        head.left = tail;
        tail.right = head;
        return head;
    }
}

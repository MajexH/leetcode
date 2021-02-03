package chapter4;

public class TreeToDoublyList_36 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    // 后续遍历 在访问父节点的时候 子节点都已经变化完了
    public void recursion(Node node) {
        if (node == null) {
            return;
        }
        recursion(node.left);
        recursion(node.right);

        // 连接左边的
        Node left = node.left;
        if (left != null) {
            // 需要找到 左子树的 最右节点
            while (left.right != null) {
                left = left.right;
            }
            left.right = node;
            node.left = left;
        }

        // 连接右边
        Node right = node.right;
        if (right != null) {
            while (right.left != null) {
                right = right.left;
            }
            right.left = node;
            node.right = right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        recursion(root);
        Node head = root, tail = root;
        while (head.left != null) {
            head = head.left;
        }
        while (tail.right != null) {
            tail = tail.right;
        }
        head.left = tail;
        tail.right = head;
        return head;
    }
}

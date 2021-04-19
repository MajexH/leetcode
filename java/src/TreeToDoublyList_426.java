public class TreeToDoublyList_426 {

    static class Node {
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
            right.left = node;
            node.right = right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        recursion(root);
        Node mv = root;
        while (root.left != null) {
            root = root.left;
        }
        while (mv.right != null) {
            mv = mv.right;
        }
        mv.right = root;
        root.left = mv;
        return root;
    }

    public static void main(String[] args) {
        Node node = new Node(4);
        node.left = new Node(2);
        node.right = new Node(5);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
        System.out.println(new TreeToDoublyList_426().treeToDoublyList(node));
    }
}

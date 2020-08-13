public class ConvertBSTToList_36_example {

    static class Node {
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

    public void recursion(Node node) {
        if (node == null) return;
        recursion(node.left);
        recursion(node.right);

        // 相当于 遍历的时候 找到 左子树的 最右节点
        // 然后连接起来
        Node cur = node.left;
        if (cur != null){
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = node;
            node.left = cur;
        }

        cur = node.right;
        if (cur == null) return;
        while (cur.left != null) {
            cur = cur.left;
        }
        cur.left = node;
        node.right = cur;
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

    public static void main(String[] args) {
        Node node = new Node(2);
        node.right = new Node(3);
        new ConvertBSTToList_36_example().treeToDoublyList(node);
    }
}

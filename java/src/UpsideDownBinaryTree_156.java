
public class UpsideDownBinaryTree_156 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    // 后序遍历
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        return recursion(root);
    }

    public TreeNode recursion(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left != null) {
            root.left = recursion(root.left);
        }
        if (root.right != null) root.right = recursion(root.right);
        TreeNode rem = root.left;
        TreeNode cur = root.left;
        if (cur == null) {
            return root;
        }
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.left = root.right;
        cur.right = root;
        root.right = null;
        root.left = null;
        return rem;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        System.out.println(new UpsideDownBinaryTree_156().upsideDownBinaryTree(node));
    }
}

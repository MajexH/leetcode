public class FlattenBinaryTree_114 {

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
    }

    public void recursion(TreeNode node) {
        if (node == null) return;
        recursion(node.left);
        recursion(node.right);
        TreeNode cur = node.left;
        if (cur == null) return;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = node.right;
        node.right = node.left;
        node.left = null;
    }

    public void flatten(TreeNode root) {
        recursion(root);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.right = new TreeNode(6);
        new FlattenBinaryTree_114().recursion(node);
        System.out.println(node);
    }
}

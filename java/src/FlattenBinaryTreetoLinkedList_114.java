public class FlattenBinaryTreetoLinkedList_114 {

    public class TreeNode {
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

    public void flatten(TreeNode root) {
        postOrder(root);
    }

    public void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);

        TreeNode left = node.left;
        if (left == null) return;
        // 找到左子树的最右节点 这样把节点挂上去才对
        while (left.right != null) {
            left = left.right;
        }
        left.right = node.right;
        node.right = node.left;
        node.left = null;
    }

}

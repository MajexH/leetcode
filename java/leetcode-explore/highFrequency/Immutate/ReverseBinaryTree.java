package highFrequency.Immutate;

public class ReverseBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode recursion(TreeNode node) {
        if (node == null) return null;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        recursion(node.left);
        recursion(node.right);
        return node;
    }

    public TreeNode invertTree(TreeNode root) {
        return recursion(root);
    }
}

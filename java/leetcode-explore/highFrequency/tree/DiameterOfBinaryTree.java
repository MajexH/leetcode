package highFrequency.tree;

public class DiameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int res = Integer.MIN_VALUE;

    public int recursion(TreeNode node) {
        if (node == null) return 0;
        int left = recursion(node.left);
        int right = recursion(node.right);
        res = Math.max(res, left + right + 1);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        res = Integer.MIN_VALUE;
        recursion(root);
        return res - 1;
    }
}

package chapter6;

public class BSTLowestCommonAncestor_68 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode recursion(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;
        if (node.val <= Math.max(p.val, q.val) && node.val >= Math.min(p.val, q.val)) {
            return node;
        }
        if (Math.min(p.val, q.val) > node.val) return recursion(node.right, p, q);
        else if (Math.max(p.val, q.val) < node.val) return recursion(node.left, p, q);
        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        return recursion(root, p, q);
    }
}

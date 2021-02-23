package chapter6;

class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        return recursion(root, p, q);
    }

    public TreeNode recursion(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }

        if (p.val > node.val && q.val > node.val) {
            return recursion(node.right, p, q);
        } else if (p.val < node.val && q.val < node.val) {
            return recursion(node.left, p, q);
        } else {
            return node;
        }
    }
}

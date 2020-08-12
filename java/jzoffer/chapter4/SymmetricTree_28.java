package chapter4;

public class SymmetricTree_28 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return recursion(root, root);
    }

    public boolean recursion(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        return node1.val == node2.val && recursion(node1.left, node2.right) && recursion(node1.right, node2.left);
    }
}

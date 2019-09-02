package ValidateBinarySearchTree98;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean recursion(TreeNode node, long min, long max) {
        if (node == null) return true;
        else if (node.val < max && node.val > min)
            return recursion(node.left, min, node.val) && recursion(node.right, node.val, max);
        else return false;
    }
}

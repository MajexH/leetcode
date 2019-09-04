package SymmetricTree101;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return recursion(root, root);
    }

    public boolean recursion(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val) && recursion(left.right, right.left) && recursion(left.left, right.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = node.right = new TreeNode(2);
        node.left.left = node.right.right = new TreeNode(3);
        node.left.right = node.right.left = new TreeNode(4);
        System.out.println(new Solution().isSymmetric(node));
    }
}

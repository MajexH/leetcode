package SumRoottoLeafNumbers129;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public int sumNumbers(TreeNode root) {
        return recursion(root, 0);
    }

    public int recursion(TreeNode node, int sum) {
        if (node == null) return 0;
        int temp = sum * 10 + node.val;
        if (node.left == null && node.right == null) return temp;
        else return recursion(node.left, temp) + recursion(node.right, temp);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(new Solution().sumNumbers(root));
    }
}

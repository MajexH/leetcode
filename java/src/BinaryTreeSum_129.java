public class BinaryTreeSum_129 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int res = 0;

    private void recursion(TreeNode node, int sum) {
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            res += sum;
            return;
        }
        if (node.left != null) recursion(node.left, sum);
        if (node.right != null) recursion(node.right, sum);
    }


    public int sumNumbers(TreeNode root) {
        res = 0;
        if (root == null) return res;
        recursion(root, 0);
        return res;
    }
}

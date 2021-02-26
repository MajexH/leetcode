package highFrequency.tree;

public class DiameterOfBinaryTreeNew {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int res = 0;

    // 二叉树直径 指的是任意两个节点路径长度中的最大值
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        if (root == null) {
            return res;
        }
        recursion(root);
        return res - 1;
    }

    public int recursion(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = recursion(node.left), right = recursion(node.right);

        // 比较最大值
        res = Math.max(res, right + left + 1);
        return Math.max(left, right) + 1;
    }
}

package DiameterofBinaryTree543;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int res;

    public int diameterOfBinaryTree(TreeNode root) {
        this.res = 1;
        recursion(root);
        return res - 1;
    }

    public int recursion (TreeNode node) {
        if (node == null) return 0;
        // 找到当前节点左边路径的节点数最大值
        int left = recursion(node.left);
        // 找到当前节点右边路径节点数的最大值
        int right = recursion(node.right);
        // 当前路径节点数与现在的最大值相比
        this.res = Math.max(res, left + right + 1);
        // 返回上一层的是两个路径长度中节点数的较大值
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(solution.diameterOfBinaryTree(root));
    }
}

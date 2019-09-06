package PathSum112;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return recursion(root, 0, sum);
    }

    // dfs
    public boolean recursion(TreeNode node, int sum, int target) {
        // 到达叶子结点
        if (node.left == null && node.right == null) {
            return sum + node.val == target;
        }
        boolean flag = false;
        // 左右子树有一个就可以
        if (node.left != null) flag = recursion(node.left, sum + node.val, target);
        if (node.right != null) flag = flag || recursion(node.right, sum + node.val, target);
        return flag;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.right.right = new TreeNode(1);
        System.out.println(new Solution().hasPathSum(node, 21));
    }
}

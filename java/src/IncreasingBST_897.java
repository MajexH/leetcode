public class IncreasingBST_897 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode cur;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode(1);
        res.right = root;
        cur = res;
        recursion(root);
        return res.right;
    }

    public void recursion(TreeNode node) {
        if (node == null) return;
        recursion(node.left);

        cur.right = node;
        node.left = null;
        cur = node;

        recursion(node.right);
    }
}

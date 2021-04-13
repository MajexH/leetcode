public class MinDiffInBST_783 {
    public static class TreeNode {
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

    // 返回的是任意两个节点之间的最小差值
    // 因为是 bst 所以根节点要跟左节点的最右节点比较
    // 以及 右子树的最左子树比较
    public int minDiffInBST(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        int leftRes = Integer.MAX_VALUE, rightRes = Integer.MAX_VALUE;
        TreeNode left = root.left;
        if (left != null) {
            while (left.right != null) {
                left = left.right;
            }
            leftRes = Math.abs(root.val - left.val);
        }

        TreeNode right = root.right;
        if (right != null) {
            while (right.left != null) {
                right = right.left;
            }
            rightRes = Math.abs(root.val - right.val);
        }
        leftRes = Math.min(leftRes, minDiffInBST(root.left));
        rightRes = Math.min(rightRes, minDiffInBST(root.right));
        return Math.min(leftRes, rightRes);
    }

    private int pre;
    private int res;

    // 中序遍历更简单
    public int minDiffInBSTInorder(TreeNode root) {
        pre = -1;
        res = Integer.MAX_VALUE;
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root) {

        if (root == null) return;
        inorder(root.left);
        if (pre != -1) {
            res = Math.min(res, Math.abs(root.val) - pre);
        }
        pre = root.val;
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(90);
        node.left = new TreeNode(69);
        node.left.left = new TreeNode(49);
        node.left.right = new TreeNode(89);
        node.left.left.left = new TreeNode(52);

        System.out.println(new MinDiffInBST_783().minDiffInBST(node));
    }
}

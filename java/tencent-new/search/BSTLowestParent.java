package search;

public class BSTLowestParent {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;

        while (root != null) {
            if (pVal > root.val && qVal > root.val) {
                root = root.right;
            } else if (qVal < root.val && pVal < root.val) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }
}

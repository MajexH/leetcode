package shopee;

import java.util.Arrays;
import java.util.Collections;

public class MaxPathSum {

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

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        postOrder(root);
        return res;
    }

    public int postOrder(TreeNode root) {
        if (root == null) return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        res = Math.max(res, Collections.max(Arrays.asList(left + root.val, right + root.val, left + right + root.val, root.val)));
        return Math.max(Math.max(left, right) + root.val, root.val);
    }
}

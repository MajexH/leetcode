package algorithmInterview.dp;

import java.util.Arrays;
import java.util.Collections;

public class BinaryTreeMaxPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int res = Integer.MIN_VALUE;

    public int recursion(TreeNode root) {
        if (root == null) return 0;
        int left = recursion(root.left);
        int right = recursion(root.right);
        res = Math.max(res, Collections.max(Arrays.asList(root.val + left + right, root.val + left, root.val + right, root.val)));
        return Math.max(root.val, Math.max(left, right) + root.val);
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        res = Integer.MIN_VALUE;
        recursion(root);
        return res;
    }
}

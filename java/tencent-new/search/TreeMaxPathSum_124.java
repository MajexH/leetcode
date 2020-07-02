package search;

import java.util.Arrays;
import java.util.Collections;

public class TreeMaxPathSum_124 {

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

    private int res = Integer.MIN_VALUE;
    // 这儿找到路径 不一定是根节点出发的
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        recursion(root);
        return res;
    }

    public int recursion(TreeNode root) {
        if (root == null) return 0;
        int left = recursion(root.left), right = recursion(root.right);
        // 与当前根节点相连的最大值 代表了一个路径
        int temp = Collections.max(Arrays.asList(root.val, left + root.val, right + root.val, left + right + root.val));
        res = Collections.max(Arrays.asList(temp, res));
        // 返回值的时候 不能两遍都返回 因此需要拿到这个地方的一条路径的最大值
        return root.val + Math.max(Math.max(left, right), 0);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);

        node.left.left = new TreeNode(11);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(14);

        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);

        node.right.right.right = new TreeNode(1);
        System.out.println(new TreeMaxPathSum_124().maxPathSum(node));
    }
}

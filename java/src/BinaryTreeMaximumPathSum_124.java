import java.util.Arrays;
import java.util.Collections;

public class BinaryTreeMaximumPathSum_124 {
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

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        recursion(root);
        return maxSum;
    }

    // 返回这个节点上能够形成的最大路径值的结果
    public int recursion(TreeNode node) {
        if (node == null) return 0;

        // 这个地方就是去获取左右两边能够形成的最大的路径值
        int left = recursion(node.left), right = recursion(node.right);

        // 获取算上这个node节点 能够形成的 最大值路径
        int tempSum = Collections.max(Arrays.asList(node.val, node.val + left, node.val + right, node.val + left + right));
        maxSum = Math.max(tempSum, maxSum);
        // 这个地方只能选择一个分支和当前的根节点一起形成一条路径
        return node.val + Math.max(Math.max(left, right), 0);
    }

}

package chapter6;

import java.util.HashMap;
import java.util.Map;

public class IsBalancedTree_55 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int depth(TreeNode node, Map<TreeNode, Integer> memo) {
        if (node == null) return 0;
        memo.put(node, Math.max(depth(node.left, memo), depth(node.right, memo)) + 1);
        return memo.get(node);
    }

    public boolean recursion(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) return true;
        return Math.abs((root.left == null ? 0 : memo.get(root.left)) - (root.right == null ? 0 : memo.get(root.right))) <= 1
                && recursion(root.left, memo)
                && recursion(root.right, memo);
    }

    public boolean isBalanced(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        depth(root, memo);
        return recursion(root, memo);
    }
}

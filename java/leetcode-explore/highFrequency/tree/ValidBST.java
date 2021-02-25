package highFrequency.tree;

import java.util.Deque;
import java.util.LinkedList;

public class ValidBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean recursion(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        return node.val > min && node.val < max &&
                recursion(node.left, min, node.val) &&
                recursion(node.right, node.val, max);
    }

    public boolean isValidBSTWithRecursion(TreeNode root) {
        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // BST的中序遍历是一个递增的数组
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode pre = null;

        while (!queue.isEmpty() || root != null) {
            while (root != null) {
                queue.addLast(root);
                root = root.left;
            }

            if (!queue.isEmpty()) {
                root = queue.removeLast();
                if (pre != null) {
                    if (pre.val >= root.val) return false;
                }
                pre = root;
                root = root.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        new ValidBST().isValidBST(node);
    }
}

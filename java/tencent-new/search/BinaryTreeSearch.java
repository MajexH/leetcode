package search;

import java.util.LinkedList;

public class BinaryTreeSearch {

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

    public int getNodeCount(TreeNode node) {
        if (node == null) return 0;
        return getNodeCount(node.left) + getNodeCount(node.right) + 1;
    }

    public int recursion(TreeNode node, int k) {
        int leftAndItselfNodes = getNodeCount(node.left) + 1;
        if (leftAndItselfNodes < k) {
            return recursion(node.right, k - leftAndItselfNodes);
        } else if (leftAndItselfNodes > k) {
            return recursion(node.left, k);
        } else {
            return node.val;
        }
    }

    // 中序遍历
    public int iterative(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        int counter = 0;
        while (root != null || stack.size() != 0) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            if (stack.size() != 0) {
                root = stack.removeLast();
                counter++;
                if (counter == k) return root.val;
                root = root.right;
            }
        }
        return 0;
    }

    public int kthSmallest(TreeNode root, int k) {
        return iterative(root, k);
    }
}

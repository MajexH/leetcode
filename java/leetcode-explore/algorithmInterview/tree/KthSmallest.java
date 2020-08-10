package algorithmInterview.tree;

import java.util.Deque;
import java.util.LinkedList;

public class KthSmallest {

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

    // 因为是 bst 因此可以直接用中序遍历 因为中序遍历是排序的
    public int kthSmallest(TreeNode root, int k) {
        int counter = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || stack.size() > 0) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.size() > 0) {
                root = stack.pop();
                counter++;
                if (counter == k) return root.val;
                root = root.right;
            }
        }
        return -1;
    }
}

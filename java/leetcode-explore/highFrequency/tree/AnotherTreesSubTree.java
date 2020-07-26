package highFrequency.tree;

import java.util.LinkedList;

public class AnotherTreesSubTree {

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

    public boolean checkTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return s.val == t.val && checkTree(s.left, t.left) && checkTree(s.right, t.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(s);
        while (queue.size() > 0) {
            TreeNode top = queue.removeFirst();
            if (top.val == t.val) {
                if (checkTree(top, t)) return true;
            }
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
        }
        return false;
    }
}

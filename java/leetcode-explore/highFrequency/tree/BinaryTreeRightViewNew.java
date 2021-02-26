package highFrequency.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightViewNew {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean flag = true;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);

        while (!queue.isEmpty()) {
            TreeNode top = queue.removeFirst();
            if (top == null) {
                flag = true;
                if (!queue.isEmpty()) {
                    queue.addLast(null);
                }
                continue;
            }
            if (flag) {
                res.add(top.val);
                flag = false;
            }
            if (top.right != null) {
                queue.add(top.right);
            }
            if (top.left != null) {
                queue.add(top.left);
            }
        }

        return res;
    }
}

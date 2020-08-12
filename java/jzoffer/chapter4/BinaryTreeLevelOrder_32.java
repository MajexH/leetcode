package chapter4;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrder_32 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode top = queue.removeFirst();
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
            res.add(top.val);
        }
        int[] resInts = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resInts[i] = res.get(i);
        }
        return resInts;
    }
}

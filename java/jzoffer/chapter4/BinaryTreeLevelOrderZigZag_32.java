package chapter4;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderZigZag_32 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<Integer> temp = new LinkedList<>();
        boolean isLeft = true;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (queue.size() > 0) {
            TreeNode top = queue.removeFirst();
            if (top == null) {
                res.add(new ArrayList<>(temp));
                if (queue.size() == 0) break;
                queue.add(null);
                temp.clear();
                isLeft = !isLeft;
                continue;
            }
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
            if (isLeft) {
                temp.addLast(top.val);
            } else {
                temp.addFirst(top.val);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(new BinaryTreeLevelOrderZigZag_32().levelOrder(node));
    }
}

package ListAndTreeNew;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderZigZag {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Deque<Integer> temp = new LinkedList<>();
        boolean isLeft = true;
        while (queue.size() > 0) {
            TreeNode top = queue.removeFirst();
            if (top == null) {
                res.add(new ArrayList<>(temp));
                if (queue.size() == 0) break;
                temp.clear();
                queue.add(null);
                isLeft = !isLeft;
                continue;
            }
            if (top.left != null) queue.add(top.left);
            if (top.right != null) queue.add(top.right);
            if (isLeft) {
                temp.add(top.val);
            } else {
                temp.push(top.val);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.right = new TreeNode(7);
        System.out.println(new LevelOrderZigZag().zigzagLevelOrder(node));
    }
}

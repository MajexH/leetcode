package ListAndTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderZigzag {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean left = true;
        LinkedList<Integer> temp = new LinkedList<>();
        while (queue.size() != 0) {
            TreeNode top = queue.removeFirst();
            if (top == null) {
//                if (!left) {
//                    Collections.reverse(temp);
//                }
                res.add(new ArrayList<>(temp));
                if (queue.size() == 0) {
                    break;
                }
                left = !left;
                temp.clear();
                queue.add(null);
                continue;
            }
            if (left) {
                temp.add(top.val);
            } else {
                temp.addFirst(top.val);
            }
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(5);
        node.left.left.left = new TreeNode(6);
        node.left.left.right = new TreeNode(7);
        node.left.right.left = new TreeNode(8);
        node.right.left.right = new TreeNode(9);
        System.out.println(zigzagLevelOrder(node));
    }
}

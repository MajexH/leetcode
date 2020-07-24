package highFrequency.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightView {

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
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);
        // 标识是否是这一层的第一个访问的节点
        boolean flag = true;
        while (queue.size() > 0) {
            TreeNode top = queue.removeFirst();
            if (top == null) {
                if (queue.size() == 0) break;
                flag = true;
                queue.add(null);
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

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.right = new TreeNode(5);
        node.left.right.right = new TreeNode(6);

        System.out.println(new BinaryTreeRightView().rightSideView(node));
    }
}

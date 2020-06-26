package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Second {

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public List<List<Integer>> zigZagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        boolean left = true;
        queue.add(root);
        queue.add(null);

        while (queue.size() > 0) {
            TreeNode top = queue.pollFirst();
            if (top == null) {
                res.add(new ArrayList<>(temp));
                temp.clear();
                if (queue.size() == 0) break;
                queue.add(null);
                left = !left;
                continue;
            }
            if (left) {
                temp.add(top.value);
            } else {
                temp.addFirst(top.value);
            }
            if (top.left != null) queue.add(top.left);
            if (top.right != null) queue.add(top.right);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = null;
        System.out.println(new Second().zigZagLevelOrder(node));
    }
}

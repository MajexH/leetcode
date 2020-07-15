package highFrequency.classic;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrder {
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
        List<Integer> temp = new ArrayList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (queue.size() > 0) {
            TreeNode top = queue.removeFirst();
            if (top == null) {
                res.add(new ArrayList<>(temp));
                temp.clear();
                if (queue.size() == 0) {
                    break;
                }
                queue.add(null);
                continue;
            }
            temp.add(top.val);
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrderZigZag(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        // 因为为了反向 所以在加入的时候反向即可
        Deque<Integer> temp = new LinkedList<>();
        // 因为第一层已经访问完毕了 所以第二层是从右向左的
        boolean isLeft = true;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (queue.size() > 0) {
            TreeNode top = queue.removeFirst();
            if (top == null) {
                res.add(new ArrayList<>(temp));
                temp.clear();
                if (queue.size() == 0) {
                    break;
                }
                isLeft = !isLeft;
                queue.add(null);
                continue;
            }
            if (isLeft) {
                temp.add(top.val);
            } else {
                temp.push(top.val);
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
}

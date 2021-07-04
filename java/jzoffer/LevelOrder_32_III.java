import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder_32_III {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<Integer> tmp = new LinkedList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);

        boolean left = true;

        while (!queue.isEmpty()) {
            TreeNode top = queue.removeFirst();
            if (top == null) {
                res.add(new ArrayList<>(tmp));
                tmp = new LinkedList<>();
                if (queue.isEmpty()) break;
                queue.add(null);
                left = !left;
                continue;
            }
            if (left) {
                tmp.addLast(top.val);
            } else {
                tmp.addFirst(top.val);
            }
            if (top.left != null) queue.add(top.left);
            if (top.right != null) queue.add(top.right);
        }
        return res;
    }
}

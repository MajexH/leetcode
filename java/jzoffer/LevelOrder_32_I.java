import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder_32_I {
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
        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode top = queue.removeFirst();
            list.add(top.val);
            if (top.left != null) queue.add(top.left);
            if (top.right != null) queue.add(top.right);
        }
        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

import java.util.Deque;
import java.util.LinkedList;

public class FindBottomLeftValue_513 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 找到最后一层最左边的数
    // bfs 找到每一层的最开始一个数
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        Integer res = null;
        boolean first = true;

        while (!queue.isEmpty()) {
            TreeNode top = queue.removeFirst();
            if (top == null) {
                if (queue.isEmpty()) break;
                queue.add(null);
                first = true;
                continue;
            }
            if (first) {
                res = top.val;
                first = false;
            }
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
        }
        assert res != null;
        return res;
    }
}

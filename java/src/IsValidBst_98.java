import java.util.Deque;
import java.util.LinkedList;

public class IsValidBst_98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        Integer pre = null;
        Deque<TreeNode> queue = new LinkedList<>();
        while (root != null || queue.size() > 0) {
            while (root != null) {
                queue.push(root);
                root = root.left;
            }
            if (queue.size() > 0) {
                root = queue.pop();
                if (pre != null && pre >= root.val) return false;
                pre = root.val;
                root = root.right;
            }
        }
        return true;
    }
}

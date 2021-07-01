import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RightSideView_199 {

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean flag = true;

        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node == null) {
                flag = !flag;
                if (queue.isEmpty()) break;
                queue.add(null);
                continue;
            }
            if (flag) {
                flag = false;
                list.add(node.val);
            }
            if (node.right != null) queue.add(node.right);
            if (node.left != null) queue.add(node.left);
        }
        return list;
    }
}

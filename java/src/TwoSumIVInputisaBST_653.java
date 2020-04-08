import java.util.HashSet;
import java.util.LinkedList;

public class TwoSumIVInputisaBST_653 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || stack.size() != 0) {
            while (root != null) {
                stack.push(root);
                if (set.contains(k - root.val)) return true;
                set.add(root.val);
                root = root.left;
            }
            if (stack.size() != 0) {
                root = stack.pop();
                root = root.right;
            }
        }
        return false;
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author majexh
 */
public class BinaryTreePreorderTraversal {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        while (root != null || stack.size() > 0) {
            while (root != null) {
                stack.add(root);
                res.add(root.val);
                root = root.left;
            }
            if (stack.size() > 0) {
                root = stack.removeLast();
                root = root.right;
            }
        }
        return res;
    }
}

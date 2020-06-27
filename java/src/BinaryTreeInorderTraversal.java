import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author majexh
 */
public class BinaryTreeInorderTraversal {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (root != null || stack.size() > 0) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            if (stack.size() > 0) {
                root = stack.removeLast();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversalWithRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursion(root, res);
        return res;
    }

    public void recursion(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        recursion(node.left, res);
        res.add(node.val);
        recursion(node.right, res);
    }

}

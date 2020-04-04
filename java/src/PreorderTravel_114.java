import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PreorderTravel_114 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (root != null || stack.size() != 0) {
            while (root != null) {
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            if (stack.size() != 0) {
                root = stack.pop();
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

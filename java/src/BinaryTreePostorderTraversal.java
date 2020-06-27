import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Boolean> stackForBoolean = new LinkedList<>();

        while (root != null || stack.size() > 0) {
            while (root != null) {
                stack.add(root);
                stackForBoolean.add(Boolean.FALSE);
                root = root.left;
            }
            if (stack.size() > 0) {
                root = stack.removeLast();
                Boolean flag = stackForBoolean.removeLast();
                // 第一次访问
                if (!flag) {
                    stack.add(root);
                    stackForBoolean.add(Boolean.TRUE);
                    root = root.right;
                } else {
                    // 第二次访问
                    res.add(root.val);
                    root = null;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        System.out.println(new BinaryTreePostorderTraversal().postorderTraversal(node));
    }
}

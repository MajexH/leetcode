import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostOrderTravel_145 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> stackForNode = new LinkedList<>();
        Deque<Boolean> stackForFlag = new LinkedList<>();
        while (root != null || stackForNode.size() > 0) {
            while (root != null) {
                stackForNode.add(root);
                stackForFlag.add(Boolean.FALSE);
                root = root.left;
            }
            if (!stackForNode.isEmpty()) {
                boolean flag = stackForFlag.removeLast();
                root = stackForNode.removeLast();

                // 说明是第二次访问
                if (flag) {
                    res.add(root.val);
                    root = null;
                } else {
                    // 第一次访问
                    stackForNode.add(root);
                    stackForFlag.add(Boolean.TRUE);
                    root = root.right;
                }
            }
        }
        return res;
    }
}

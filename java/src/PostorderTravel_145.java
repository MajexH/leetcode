import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PostorderTravel_145 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stackForNode = new LinkedList<>();
        LinkedList<Boolean> stackForBoolean = new LinkedList<>();
        while (root != null || stackForNode.size() != 0) {
            while (root != null) {
                stackForBoolean.push(Boolean.FALSE);
                stackForNode.push(root);
                root = root.left;
            }
            if (stackForNode.size() != 0) {
                root = stackForNode.pop();
                Boolean temp = stackForBoolean.pop();
                if (temp) {
                    // 第二次弹出
                    res.add(root.val);
                    // 说明现在已经这个节点及其子节点已经访问完毕 需要从stack中拿出其它的访问
                    root = null;
                } else {
                    stackForNode.push(root);
                    stackForBoolean.push(Boolean.TRUE);
                    root = root.right;
                }
            }
        }
        return res;
    }
}

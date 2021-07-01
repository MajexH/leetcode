import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeafSimilar_872 {

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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = getLeaf(root1);
        List<Integer> l2 = getLeaf(root2);

        return l1.size() == l2.size() && l1.equals(l2);
    }

    private List<Integer> getLeaf(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }
        dfs(node.left, res);
        dfs(node.right, res);
    }

}

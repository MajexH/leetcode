import java.util.ArrayList;
import java.util.List;

public class PathSum_34 {
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

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        recursion(root, target, res, new ArrayList<>());
        return res;
    }

    private void recursion(TreeNode node, int target, List<List<Integer>> res, List<Integer> tmp) {
        tmp.add(node.val);
        if (node.left == null && node.right == null) {
            if (target == node.val) {
                res.add(new ArrayList<>(tmp));
            }
            tmp.remove(tmp.size() - 1);
            return;
        }
        if (node.left != null) recursion(node.left, target - node.val, res, tmp);
        if (node.right != null) recursion(node.right, target - node.val, res, tmp);
        tmp.remove(tmp.size() - 1);
    }
}

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSumII_113 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void recursion(List<List<Integer>> res, List<Integer> temp, TreeNode node, int sum, int target) {
        temp.add(node.val);
        sum += node.val;
        if (node.left == null && node.right == null) {
           if (sum == target) {
               res.add(new ArrayList<>(temp));
           }
           temp.remove(temp.size() - 1);
           return;
        }
        if (node.left != null) {
            recursion(res, temp, node.left, sum, target);
        }
        if (node.right != null) {
            recursion(res, temp, node.right, sum, target);
        }
        temp.remove(temp.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        recursion(res, new ArrayList<>(), root, 0, sum);
        return res;
    }
}

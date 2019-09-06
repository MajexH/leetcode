package PathSumII113;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        recursion(root, sum, res, new ArrayList<>(), 0);
        return res;
    }

    public void recursion(TreeNode node, int target, List<List<Integer>> res, List<Integer> temp, int sum) {
        temp.add(node.val);
        // 到达叶子结点
        if (node.left == null && node.right == null) {
            if (sum + node.val == target) {
                res.add(new ArrayList<>(temp));
            }
            temp.remove(temp.size() - 1);
            return;
        }
        if (node.left != null) {
            recursion(node.left, target, res, temp, sum + node.val);
        }
        if (node.right != null) {
            recursion(node.right, target, res, temp, sum + node.val);
        }
        temp.remove(temp.size() - 1);
    }
}

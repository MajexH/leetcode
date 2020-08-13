package chapter4;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum_34 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 一定要到叶子节点
    public void recursion(TreeNode node, int sum, List<List<Integer>> res, List<Integer> temp) {
        sum  = sum - node.val;
        temp.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(temp));
            }
            temp.remove(temp.size() - 1);
            return;
        }
        if (node.left != null) recursion(node.left, sum, res, temp);
        if (node.right != null) recursion(node.right, sum, res, temp);
        temp.remove(temp.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        recursion(root, sum, res, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.left = new TreeNode(5);
        node.right.right.right = new TreeNode(1);

        System.out.println(new BinaryTreePathSum_34().pathSum(node, 22));
    }
}

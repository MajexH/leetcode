package SecondMinimumNodeInaBinaryTree671;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int findSecondMinimumValue(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        int min = Integer.MIN_VALUE, res = root.val;
        boolean flag = true;
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode top = list.remove(0);
            if (top.val > min && top.val < res) {
                res = top.val;
            }
            if (top.val > res && flag) {
                flag = false;
                min = res;
                res = top.val;
            }
            if (top.left != null) list.add(top.left);
            if (top.right != null) list.add(top.right);
        }
        return res == root.val ? -1 : res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(5);
        System.out.println(solution.findSecondMinimumValue(node));
    }
}

package MinimumDepthofBinaryTree111;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        if (left == 0) return right + 1;
        else if (right == 0) return left + 1;
        else return Math.min(left, right) + 1;
    }

    /**
     * 非递归实现
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        list.add(null);
        int min = 1;
        while (list.size() != 0) {
            TreeNode top = list.remove(0);
            if (top == null) {
                // 一层已经完了
                min++;
                if (list.size() == 0) break;
                else {
                    list.add(null);
                }
                continue;
            }
            if (top.left == null && top.right == null) {
                return min;
            }
            if (top.left != null) list.add(top.left);
            if (top.right != null) list.add(top.right);
        }
        return min;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(new Solution().minDepth(node));
    }
}

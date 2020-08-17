package chapter6;

import java.util.Deque;
import java.util.LinkedList;

public class KthMaxIntBST_54 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int getNodeCount(TreeNode root) {
        if (root == null) return 0;
        return 1 + getNodeCount(root.left) + getNodeCount(root.right);
    }
    // 这个方法是通过 getNodeCount 得到整体的节点数多少
    // 然后再根据节点数 将 第K大 转换为 第 length - k + 1 小的节点
    // 比较慢
    public int kthLargest1(TreeNode root, int k) {
        int length = getNodeCount(root);
        int counter = length - k + 1;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || stack.size() > 0) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.size() > 0) {
                root = stack.pop();
                counter--;
                if (counter == 0) return root.val;
                root = root.right;
            }
        }
        return -1;
    }

    public TreeNode recursion(TreeNode root, int k) {
        if (root == null) return null;
        int rightLength = getNodeCount(root.right);
        int index = rightLength + 1;
        // 说明这个地方已经是 第 k 大了
        if (index == k)
            return root;
        // 说明在右边
        else if (index > k) return recursion(root.right, k);
        else return recursion(root.left, k - index);

    }

    // 这个方法采用递归来做
    public int kthLargest(TreeNode root, int k) {
        TreeNode node = recursion(root, k);
        if (node == null) return -1;
        else return node.val;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.left.right = new TreeNode(2);
        System.out.println(new KthMaxIntBST_54().kthLargest(node, 3));
    }
}

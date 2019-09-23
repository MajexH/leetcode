package FlattenBinaryTreetoLinkedList114;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 不需要按照大小来 只需要直接把左子树的所有放到右子树即可
    public void flatten(TreeNode root) {
        if (root == null) return;
        // 遍历左右子树
        flatten(root.left);
        flatten(root.right);
        TreeNode cur = root.left;
        if (cur == null) return;
        while (cur.right != null) cur = cur.right;
        cur.right = root.right;
        root.right = root.left;
        root.left = null;
    }

    public static void main(String[] args) {

    }
}

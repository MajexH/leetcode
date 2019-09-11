package KthSmallestElementinaBST230;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        return recursion(root, k);
    }

    public int recursion(TreeNode root, int k) {
       int count = getCount(root.left) + 1;
       if (count > k) {
           return recursion(root.left, k);
       } else if (count < k) {
           return recursion(root.right, k - count);
       } else {
           return root.val;
       }
    }

    public int getCount(TreeNode node) {
        if (node == null) return 0;
        else return getCount(node.left) + getCount(node.right) + 1;
    }
}

package KthSmallestElementInaBST;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 因为是一个BST 也就是说 左边的是小于根的 右边的是大于根的 所以找K小只要左边的节点数就可以了
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = getCount(root.left) + 1;
        if (k > leftCount) {
            return kthSmallest(root.right, k - leftCount);
        } else if (k < leftCount) {
            return kthSmallest(root.left, k);
        } else {
            return root.val;
        }
    }

    public int getCount(TreeNode node) {
        if (node == null) return 0;
        return 1 + getCount(node.left) + getCount(node.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.left.left.left = new TreeNode(1);

        System.out.println(solution.kthSmallest(node, 3));
    }
}

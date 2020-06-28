import java.util.LinkedList;

public class ValidateBinarySearchTree98 {

    public static class TreeNode {
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

    public boolean recursion(TreeNode root, long low, long peak) {
        if (root == null) return true;
        if (root.val < peak && root.val > low)
            return recursion(root.left, low, root.val) && recursion(root.right, root.val, peak);
        return false;
    }

    public boolean isValidBST(TreeNode root) {
//        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return iterative(root);
    }

    // BST 的中序遍历是一个正常的递增数组
    public boolean iterative(TreeNode root) {
        Integer pre = null;

        LinkedList<TreeNode> stack = new LinkedList<>();

        while (root != null || stack.size() > 0) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (stack.size() > 0) {
                root = stack.poll();
                if (pre != null) {
                    if (pre >= root.val) return false;
                }
                pre = root.val;
                root = root.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(1);
//        node.right = new TreeNode(3);
        System.out.println(new ValidateBinarySearchTree98().isValidBST(node));
    }
}

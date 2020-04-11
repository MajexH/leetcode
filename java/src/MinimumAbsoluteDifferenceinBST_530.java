import java.util.LinkedList;

public class MinimumAbsoluteDifferenceinBST_530 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private TreeNode pre = null;
    private int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || stack.size() != 0) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.size() != 0) {
                root = stack.pop();
                if (pre != null) {
                    res = Math.min(res, Math.abs(pre.val - root.val));
                }
                pre = root;
                root = root.right;
            }
        }
        return this.res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(7);
        System.out.println(new MinimumAbsoluteDifferenceinBST_530().getMinimumDifference(node));
    }
}

public class FindSecondMinimumValue_671 {
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

    private static int res;
    private static int rootVal;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        res = -1;
        rootVal = root.val;
        recursion(root);
        return res;
    }

    private void recursion(TreeNode root) {
        if (root == null) return;
        if (res != -1 && root.val >= res) return;
        if (root.val > rootVal) res = root.val;
        recursion(root.left);
        recursion(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(2);
        node.right = new TreeNode(Integer.MAX_VALUE);

        System.out.println(new FindSecondMinimumValue_671().findSecondMinimumValue(node));
    }
}

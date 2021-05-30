public class IsCousins_993 {

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

    private static class Pair {
        TreeNode parent;
        int depth;

        public Pair(TreeNode parent, int depth) {
            this.parent = parent;
            this.depth = depth;
        }
    }

    Pair xP = null, yP = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        xP = null;
        yP = null;
        backTrack(root, x, y, 0, null);
        return (xP.parent != yP.parent && xP.depth == yP.depth);
    }

    private void backTrack(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if (root == null) return;
        if (root.val == x) {
            xP = new Pair(parent, depth + 1);
        }
        if (root.val == y) {
            yP = new Pair(parent, depth + 1);
        }
        backTrack(root.left, x, y, depth + 1, root);
        backTrack(root.right, x, y, depth + 1, root);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        System.out.println(new IsCousins_993().isCousins(node, 1, 3));
    }
}

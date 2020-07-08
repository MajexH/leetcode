public class BinarySearchTreeIterator_173 {

    public class TreeNode {
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

    private TreeNode node;
    private int min;

    public BinarySearchTreeIterator_173(TreeNode root) {
        this.node = root;
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {
            min = node.val;
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    /** @return the next smallest number */
    public int next() {
        this.node = deleteMin(this.node);
        return min;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.node != null;
    }
}

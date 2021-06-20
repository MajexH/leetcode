package chapter2.tree;

public class BuildTree_7 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursion(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode recursion(int[] preOrder, int preOrderStart, int preOrderEnd,
                              int[] inOder, int inOrderStart, int inOrderEnd) {
        if (preOrderStart > preOrderEnd) return null;
        if (preOrderStart == preOrderEnd) {
            return new TreeNode(preOrder[preOrderStart]);
        }

        int root = preOrder[preOrderStart];
        TreeNode node = new TreeNode(root);
        int index = findIndex(inOder, root, inOrderStart, inOrderEnd);
        int len = index - inOrderStart;
        node.left = recursion(preOrder, preOrderStart + 1, preOrderStart + len, inOder, inOrderStart, index - 1);
        node.right = recursion(preOrder, preOrderStart + len + 1, preOrderEnd, inOder, index + 1, inOrderEnd);
        return node;
    }

    private int findIndex(int[] nums, int num, int start, int end) {
        while (start <= end) {
            if (nums[start] == num) return start;
            start++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BuildTree_7().buildTree(new int[]{1,2}, new int[]{1,2}));
    }
}

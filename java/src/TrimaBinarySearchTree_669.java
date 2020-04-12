public class TrimaBinarySearchTree_669 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        return recursion(root, L, R);
    }

    public TreeNode recursion(TreeNode node, int L, int R) {
        if (node == null) return null;
        // 如果node.val 小于下界 说明左边的节点和自己 都是需要被trim 掉的
        // 而右边可能比下界大 因此需要去遍历查看
        if (node.val < L) {
            return recursion(node.right, L, R);
        }
        if (node.val > R) {
            return recursion(node.left, L, R);
        }
        node.left = recursion(node.left, L, R);
        node.right = recursion(node.right, L, R);
        return node;
    }
}

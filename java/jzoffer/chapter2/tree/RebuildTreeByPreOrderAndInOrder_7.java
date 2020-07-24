package chapter2.tree;

public class RebuildTreeByPreOrderAndInOrder_7 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
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

    public TreeNode recursion(int[] preOrders, int startOfPre, int endOfPre,
                              int[] inOrders, int startOfIn, int endOfIn) {
        if (startOfPre > endOfPre || startOfIn > endOfIn) return null;
        TreeNode root = new TreeNode(preOrders[startOfPre]);
        int i = startOfIn;
        for (; i <= endOfIn; i++) {
            if (preOrders[startOfPre] == inOrders[i])
                break;
        }
        assert inOrders[i] == preOrders[startOfPre];
        int leftLength = i - startOfIn;
        root.left = recursion(preOrders, startOfPre + 1, startOfPre + leftLength,
                            inOrders, startOfIn, i - 1);
        root.right = recursion(preOrders, startOfPre + leftLength + 1, endOfPre,
                            inOrders, i + 1, endOfIn);
        return root;
    }

    /**
     * 根据一个二叉树的前序遍历和中序遍历重建这棵树
     * @param preOrders 前序遍历结果
     * @param inOrders 中序遍历结果
     * @return 返回这颗树
     */
    public TreeNode rebuildTree(int[] preOrders, int[] inOrders) {
        return recursion(preOrders, 0, preOrders.length - 1,
                        inOrders, 0, inOrders.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new RebuildTreeByPreOrderAndInOrder_7().rebuildTree(new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6}));
    }
}

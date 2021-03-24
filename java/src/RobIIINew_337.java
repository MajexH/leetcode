public class RobIIINew_337 {
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

    private static class Pair {
        int notRob;
        int rob;

        public Pair(int notRob, int rob) {
            this.notRob = notRob;
            this.rob = rob;
        }
    }

    // 树形结构的 rob
    public int rob(TreeNode root) {
        Pair p = recursion(root);
        return Math.max(p.notRob, p.rob);
    }

    public Pair recursion(TreeNode node) {
        if (node == null) return new Pair(0, 0);

        Pair left = recursion(node.left);
        Pair right = recursion(node.right);

        // 当前 rob 节点都不能 rob
        int rob = left.notRob + right.notRob + node.val;
        // 当前不 rob 取最大值
        int notRob = Math.max(left.notRob, left.rob) + Math.max(right.notRob, right.rob);
        return new Pair(notRob, rob);
    }
}

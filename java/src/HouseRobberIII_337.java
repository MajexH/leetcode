public class HouseRobberIII_337 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class Pair {
        public int take;
        public int notTake;

        public Pair(int take, int notTake) {
            this.take = take;
            this.notTake = notTake;
        }
    }

    // 返回的 Pair 表示的是 拿这个点和不拿这个点的最大值
    public Pair recursion(TreeNode node) {
        if (node == null) return new Pair(0, 0);
        Pair left = recursion(node.left);
        Pair right = recursion(node.right);
        int take = node.val + left.notTake + right.notTake;
        int notTake = Math.max(Math.max(left.take + right.take, left.notTake + right.notTake),
                Math.max(left.take + right.notTake, left.notTake + right.take));

        return new Pair(take, notTake);
    }

    public int rob(TreeNode root) {
        Pair res = recursion(root);
        return Math.max(res.notTake, res.take);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
//        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(4);
//        node.right.right = new TreeNode(1);
        System.out.println(new HouseRobberIII_337().rob(node));
    }
}

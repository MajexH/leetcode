public class bst {


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

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

    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) return null;
        return recursion(num, 0, num.length - 1);
    }

    public TreeNode recursion(int[] num, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(num[left]);
        int mid = (int) Math.ceil((left + right) / 2D);

        // 没有构造函数
        TreeNode node = new TreeNode(num[mid]);
        // node.val = num[mid];
        node.left = recursion(num, left, mid - 1);
        node.right = recursion(num, mid + 1, right);

        return node;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,3};
        System.out.println(new bst().sortedArrayToBST(num));
    }
}

public class SortedArrayToBST_108 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode recursion(int[] nums, int i, int j) {
        if (i > j) return null;
        int mid = (i + j) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = recursion(nums, i, mid - 1);
        node.right = recursion(nums, mid + 1, j);
        return node;
    }

    // 一个排序数组转换成为高度平衡的二叉树
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length - 1);
    }
}

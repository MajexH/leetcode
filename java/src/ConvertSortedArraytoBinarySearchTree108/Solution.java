package ConvertSortedArraytoBinarySearchTree108;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length - 1);
    }

    public TreeNode recursion(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursion(nums, start, mid - 1);
        root.right = recursion(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }
}

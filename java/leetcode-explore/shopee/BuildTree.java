package shopee;

import com.sun.source.tree.Tree;

import java.util.Arrays;

public class BuildTree {
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
        return recursion(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode recursion(int[] preOrder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd) return null;
        TreeNode node = new TreeNode(preOrder[pStart]);
        int index = findIndex(inorder, preOrder[pStart], iStart, iEnd);
        node.left = recursion(preOrder, pStart + 1, index - iStart + pStart, inorder, iStart, index - 1);
        node.right = recursion(preOrder, index - iStart + pStart + 1, pEnd, inorder, index + 1, iEnd);
        return node;
    }

    private int findIndex(int[] inorder, int target, int start, int end) {
        while (start <= end) {
            if (inorder[start] == target) {
                return start;
            }
            start++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BuildTree().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
}

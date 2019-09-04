package ConstructBinaryTreefromInorderandPostorderTraversal106;

import java.util.Arrays;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return recursion(inorder, postorder);
    }

    public TreeNode recursion(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        int root = postorder[postorder.length - 1];
        TreeNode node = new TreeNode(root);
        int position = findIndex(inorder, root);
        node.left = recursion(Arrays.copyOfRange(inorder, 0, position), Arrays.copyOfRange(postorder, 0, position));
        node.right = recursion(Arrays.copyOfRange(inorder, position + 1, inorder.length), Arrays.copyOfRange(postorder, position, postorder.length - 1));
        return node;
    }

    public int findIndex(int[] array, int key) {
        int index = 0;
        while (array[index++] != key) {
        }
        return index - 1;
    }

    public static void main(String[] args) {
        new Solution().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }
}

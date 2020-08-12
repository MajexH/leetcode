package chapter3;

import java.util.Deque;
import java.util.LinkedList;

public class IsSubStructure_26 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSame(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null) return false;
        return a.val == b.val && isSame(a.left, b.left) && isSame(a.right, b.right);
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        Deque<TreeNode> stack = new LinkedList<>();
        while (A != null || stack.size() > 0) {
            while (A != null) {
                stack.add(A);
                if (A.val == B.val && isSame(A, B)) {
                    return true;
                }
                A = A.left;
            }
            if (stack.size() > 0) {
                A = stack.removeLast();
                A = A.right;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        a.left = new TreeNode(12);
        a.right = new TreeNode(6);
        a.left.left = new TreeNode(8);
        a.left.right = new TreeNode(3);
        a.right.left = new TreeNode(11);


        TreeNode b = new TreeNode(10);
        b.left = new TreeNode(12);
        b.right = new TreeNode(6);
        b.left.left = new TreeNode(8);

        System.out.println(new IsSubStructure_26().isSubStructure(a, b));
    }
}

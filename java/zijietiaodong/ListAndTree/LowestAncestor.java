package ListAndTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LowestAncestor {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while ((!map.containsKey(p) || !map.containsKey(q)) && stack.size() > 0) {
            TreeNode top = stack.removeLast();
            if (top.left != null) {
                map.put(top.left, top);
                stack.add(top.left);
            }
            if (top.right != null) {
                map.put(top.right, top);
                stack.add(top.right);
            }
        }

        HashSet<TreeNode> parentsChain = new HashSet<>();

        while (p != null) {
            parentsChain.add(p);
            p = map.get(p);
        }
        while (!parentsChain.contains(q)) {
            q = map.get(q);
        }
        return q;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        System.out.println(new LowestAncestor().lowestCommonAncestor(root, root.left, root.right));
    }
}

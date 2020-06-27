package ListAndTreeNew;

import java.util.*;

public class LowestAncestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TreeNode treeNode = (TreeNode) o;

            if (val != treeNode.val) return false;
            if (left != null ? !left.equals(treeNode.left) : treeNode.left != null) return false;
            return right != null ? right.equals(treeNode.right) : treeNode.right == null;
        }

        @Override
        public int hashCode() {
            int result = val;
            result = 31 * result + (left != null ? left.hashCode() : 0);
            result = 31 * result + (right != null ? right.hashCode() : 0);
            return result;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            TreeNode top = stack.poll();
            if (top.left != null) {
                parents.put(top.left, top);
                stack.push(top.left);
            }
            if (top.right != null) {
                parents.put(top.right, top);
                stack.push(top.right);
            }
        }

        Set<TreeNode> parentChain = new HashSet<>();

        while (p != null) {
            parentChain.add(p);
            p = parents.get(p);
        }

        while (!parentChain.contains(q)) {
            q = parents.get(q);
        }

        return q;
    }
}

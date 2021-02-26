package highFrequency.tree;

import java.util.*;

public class LowestCommonAncestorNew {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);

        while (!queue.isEmpty() && (!parents.containsKey(p) || !parents.containsKey(q))) {
            TreeNode top = queue.removeFirst();
            if (top.left != null) {
                queue.add(top.left);
                parents.put(top.left, top);
            }
            if (top.right != null) {
                queue.add(top.right);
                parents.put(top.right, top);
            }
        }

        Set<TreeNode> paths = new HashSet<>();
        while (p != null) {
            paths.add(p);
            p = parents.get(p);
        }
        while (!paths.contains(q)) {
            q = parents.get(q);
        }
        return q;
    }
}

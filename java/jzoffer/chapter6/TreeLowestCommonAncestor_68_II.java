package chapter6;

import java.util.*;

public class TreeLowestCommonAncestor_68_II {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0 && (!map.containsKey(p) || !map.containsKey(q))) {
            TreeNode first = queue.removeFirst();

            if (first.left != null) {
                queue.addLast(first.left);
                map.put(first.left, first);
            }

            if (first.right != null) {
                queue.addLast(first.right);
                map.put(first.right, first);
            }
        }

        Set<TreeNode> paths = new HashSet<>();

        while (p != null) {
            paths.add(p);
            p = map.get(p);
        }

        while (!paths.contains(q)) {
            q = map.get(q);
        }
        return q;
    }
}

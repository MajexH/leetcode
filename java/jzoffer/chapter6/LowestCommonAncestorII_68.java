package chapter6;

import java.util.*;

public class LowestCommonAncestorII_68 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();

        queue.add(root);
        map.put(root, null);
        while (queue.size() > 0 && !(map.containsKey(p) && map.containsKey(q))) {
            TreeNode top = queue.removeFirst();

            if (top.left != null) {
                queue.add(top.left);
                map.put(top.left, top);
            }

            if (top.right != null) {
                queue.add(top.right);
                map.put(top.right, top);
            }
        }

        Set<TreeNode> parents = new HashSet<>();
        while (p != null) {
            parents.add(p);
            p = map.get(p);
        }

        while (q != null && !parents.contains(q)) {
            q = map.get(q);
        }
        return q;
    }
}

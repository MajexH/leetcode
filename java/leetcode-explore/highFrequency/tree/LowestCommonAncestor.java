package highFrequency.tree;

import java.util.*;

public class LowestCommonAncestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // hash 可以的原因是因为 这个地方 全是比较的 Object 的 只需要判断 obj
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        parents.put(root, null);
        while (queue.size() > 0 && (!parents.containsKey(p) || !parents.containsKey(q))) {
            TreeNode top = queue.poll();
            if (top.left != null) {
                queue.add(top.left);
                parents.put(top.left, top);
            }
            if (top.right != null) {
                queue.add(top.right);
                parents.put(top.right, top);
            }
        }
        Set<TreeNode> pParents = new HashSet<>();
        while (p != null) {
            pParents.add(p);
            p = parents.get(p);
        }
        while (!pParents.contains(q)) {
            q = parents.get(q);
        }
        return q;
    }
}

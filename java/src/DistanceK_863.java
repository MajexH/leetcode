import java.util.*;

public class DistanceK_863 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        recursion(root, map);

        Deque<Integer> queue = new LinkedList<>();
        Deque<Integer> levels = new LinkedList<>();
        queue.addLast(target.val);
        levels.addLast(0);

        Set<Integer> res = new HashSet<>();
        Set<Integer> memo = new HashSet<>();

        while (!queue.isEmpty() && levels.peek() <= k) {
            Integer top = queue.removeFirst();
            Integer level = levels.removeFirst();
            memo.add(top);
            if (level == k) res.add(top);
            for (Integer adj : map.get(top)) {
                if (memo.contains(adj)) continue;
                queue.add(adj);
                levels.add(level + 1);
            }
        }
        return new ArrayList<>(res);
    }

    private void recursion(TreeNode root, Map<Integer, List<Integer>> map) {
        if (root == null) return;
        if (!map.containsKey(root.val)) map.put(root.val, new ArrayList<>());
        add(root.left, root.val, map);
        add(root.right, root.val, map);
        recursion(root.left, map);
        recursion(root.right, map);
    }

    private void add(TreeNode node, int rootVal, Map<Integer, List<Integer>> map) {
        if (node == null) return;

        map.get(rootVal).add(node.val);
        if (!map.containsKey(node.val)) map.put(node.val, new ArrayList<>());
        map.get(node.val).add(rootVal);

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(5);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);
        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(8);

        System.out.println(new DistanceK_863().distanceK(node, node.left, 2));
    }
}

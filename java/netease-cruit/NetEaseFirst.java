import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NetEaseFirst {

    public static int res = 0;

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
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

    public static void recursion(TreeNode root) {
        if (root == null) return;

        if ((root.left != null && root.left.left == null && root.left.right == null)
                && (root.right != null && root.right.left == null && root.right.right == null)) {
            res++;
        }

        recursion(root.left);
        recursion(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = null;
        int m = sc.nextInt(), n = sc.nextInt();
        Map<Integer, TreeNode> treeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = sc.nextInt();
            String direction = sc.next();
            int child = sc.nextInt();

            if (!treeMap.containsKey(parent)) {
                treeMap.put(parent, new TreeNode(parent));
            }
            if (!treeMap.containsKey(child)) {
                treeMap.put(child, new TreeNode(child));
            }

            TreeNode p = treeMap.get(parent), c = treeMap.get(child);
            if (parent == 1) root = p;

            if (direction.equals("left")) {
                p.left = c;
            } else {
                p.right = c;
            }
        }

        assert root != null;
        res = 0;
        recursion(root);
        System.out.println(res);

    }
}

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder_32_II {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);

        List<Integer> tmp = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node == null) {
                res.add(new ArrayList<>(tmp));
                tmp = new ArrayList<>();
                if (queue.size() == 0) break;
                queue.addLast(null);
                continue;
            }
            tmp.add(node.val);
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(9);
        a.right = new TreeNode(20);
        a.right.left = new TreeNode(15);
        System.out.println(new LevelOrder_32_II().levelOrder(a));
    }

}

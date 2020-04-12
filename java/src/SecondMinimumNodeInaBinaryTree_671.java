import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class SecondMinimumNodeInaBinaryTree_671 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 因为root的根节点的值永远小于其子节点
    // 因此可以是用层次遍历 如果结果集大于2 直接返回 要不然 最后返回-1
    public int findSecondMinimumValue(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode top = queue.poll();
            set.add(top.val);
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
        }
        if (set.size() < 2)
            return -1;
        else {
            int temp = 0;
            for (Integer t : set) {
                temp++;
                if (temp == 2) return t;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}

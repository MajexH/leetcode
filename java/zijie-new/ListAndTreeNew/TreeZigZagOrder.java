package ListAndTreeNew;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author majexh
 */
public class TreeZigZagOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        boolean isLeft = true;
        queue.add(root);
        queue.add(null);

        while (queue.size() > 0) {
            TreeNode top = queue.removeFirst();
            if (top == null) {
                res.add(new ArrayList<>(temp));
                // 访问完了
                if (queue.size() == 0) {
                    break;
                }
                queue.add(null);
                isLeft = !isLeft;
                temp.clear();
                continue;
            }
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }

            if (isLeft) {
                temp.addLast(top.val);
            } else {
                temp.addFirst(top.val);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

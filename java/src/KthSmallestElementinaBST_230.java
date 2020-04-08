import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KthSmallestElementinaBST_230 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || stack.size() != 0) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.size() != 0) {
                root = stack.pop();
                k--;
                if (k == 0) return root.val;
                root = root.right;
            }
        }
        return -1;
    }
}

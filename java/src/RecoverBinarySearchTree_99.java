import java.util.Deque;
import java.util.LinkedList;

public class RecoverBinarySearchTree_99 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
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

    // 保证只有一对数被交换错误 因此只需要找到这一对交换错误的数即可
    // 即找到出现逆序的几个点 因为一对数交换 会在其前后形成两对逆序
    // 因此找到这两对中的最开始 和 最结尾即可 然后交换
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (root != null || stack.size() != 0) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.size() != 0) {
                root = stack.pop();
                if (pre != null && pre.val > root.val) {
                    if (first == null) first = pre;
                    second = root;
                }
                pre = root;
                root = root.right;
            }
        }
        assert first != null && second != null;
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        new RecoverBinarySearchTree_99().recoverTree(root);
        System.out.println(root);
    }
}

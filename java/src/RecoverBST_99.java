import java.util.*;

public class RecoverBST_99 {

    public class TreeNode {
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
    }

    public void recoverTree(TreeNode root) {
        // 中序遍历找逆序
        // 因为这个可以看成是两个数交换了
        // 交换的时候 可能是相邻的交换 也可能是不相邻的交换
        // 因此 相邻的交换 只有一个逆序数对 不相邻的交换 有两个逆序数对
        // 找到逆序的最开始一对 和最结尾一对
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        // 因为可能有两对逆序数对 当有两对的时候会出现 321 这种情况 要把这个逆序的最前和最后交换
        // 因此用这个来保存
        TreeNode first = null, second = null;
        while (root != null || stack.size() > 0) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.size() > 0) {
                root = stack.pop();
                if (pre != null && pre.val >= root.val) {
                    // 逆序
                    if (first == null) first = pre;
                    second = root;
                }
                pre = root;
                root = root.right;
            }
        }
        assert first != null;
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}

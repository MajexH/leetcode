import java.util.Deque;
import java.util.LinkedList;

public class BSTIterator {

    // 中序遍历搜索的二叉树迭代器

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
    }

    Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new LinkedList<>();
        while (root != null) {
            this.stack.addLast(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode cur = this.stack.removeLast();
        // 这个时候返回 cur 但是要去遍历它的 右子树
        TreeNode right = cur.right;
        while (right != null) {
            this.stack.addLast(right);
            right = right.left;
        }
        return cur.val;
    }

    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(3);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(node);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

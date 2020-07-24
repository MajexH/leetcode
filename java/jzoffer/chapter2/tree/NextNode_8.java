package chapter2.tree;

public class NextNode_8 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        // 指向父亲的指针
        TreeNode parent;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", parent=" + parent +
                    '}';
        }
    }

    /**
     * 找到二叉树的中序遍历的下一个节点
     * @param node
     * @return
     */
    public TreeNode getNextNode(TreeNode node) {
        if (node == null) return null;
        // 如果右节点不为空 肯定先访问右节点
        if (node.right != null) {
            // 如果是其父节点的右节点
            // 但是自己的右节点不是 null 那么下一个访问的节点一定是右子树的最左节点 因为中序遍历
            TreeNode temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
        // 如果这个节点的是其父节点的左子树
        else if (node.parent != null && node.parent.left == node) {
            // 那么下一个访问的节点就是父节点
            return node.parent;
        } else {
            // 这个情况下 他既是右子树而且他自己的右子树右为空
            // 说明这个时候的 一定是某个节点的左子树已经访问完毕 那么只需要找到这个节点即可
            TreeNode temp = node.parent;
            while (temp.parent != null && temp.parent.left != temp) {
                temp = temp.parent;
            }
            return temp.parent;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode('a');
        node.left = new TreeNode('b');
        node.right = new TreeNode('c');
        node.left.parent = node;
        node.right.parent = node;

        node.left.left = new TreeNode('d');
        node.left.right = new TreeNode('e');
        node.left.left.parent = node.left.right.parent = node.left;

        node.left.right.left = new TreeNode('h');
        node.left.right.right = new TreeNode('i');
        node.left.right.left.parent = node.left.right.right.parent = node.left.right;

        node.right.left = new TreeNode('f');
        node.right.right = new TreeNode('g');
        node.right.left.parent = node.right.right.parent = node.right;

        System.out.println((char)(new NextNode_8().getNextNode(node.right.right).val));
    }
}

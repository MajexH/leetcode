package highFrequency.design;

public class Codec {

    public static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private void preOrder(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("null ");
            return;
        }
        builder.append(node.val);
        builder.append(' ');
        preOrder(node.left, builder);
        preOrder(node.right, builder);
    }

    // Encodes a tree to a single string.
    // 返回的是前序遍历的 string
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        preOrder(root, builder);
        return builder.toString();
    }

    // index 表示的是当前的遍历的 node 的位置
    private Pair buildTree(String[] nodes, int index) {
        if (index >= nodes.length || nodes[index].equals("null")) return new Pair(null, index);
        TreeNode node = new TreeNode(Integer.parseInt(nodes[index]));
        Pair left = buildTree(nodes, index + 1);
        Pair right = buildTree(nodes, left.index + 1);
        node.left = left.node;
        node.right = right.node;
        // 用 pair 里面的 index 来表示现在访问右节点的时候 需要访问哪一个节点
        // 因为前序遍历的话 中间 把 null 也加入了 不是完全二叉树那种形式
        // 只能用一个指针来表示 构建左子树的时候 已经访问了到了哪个位置 接下来才能遍历右子树
        return new Pair(node, right.index);
    }

    private static class Pair {
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(" ");
        return buildTree(nodes, 0).node;
    }
}

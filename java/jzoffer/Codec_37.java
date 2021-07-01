// 序列化二叉树
public class Codec_37 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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

    private static class Pair {
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        recursion(root, builder);
        return builder.toString();
    }

    private void recursion(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("null ");
            return;
        }
        builder.append(node.val);
        builder.append(' ');
        recursion(node.left, builder);
        recursion(node.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(" ");
        Pair p = recursionBuild(strs, 0);
        return p.node;
    }

    private Pair recursionBuild(String[] strs, int index) {
        if (index >= strs.length || strs[index].equals("null")) {
            return new Pair(null, index);
        }

        TreeNode node = new TreeNode(Integer.parseInt(strs[index]));

        Pair left = recursionBuild(strs, index + 1);
        Pair right = recursionBuild(strs, left.index + 1);
        node.left = left.node;
        node.right = right.node;
        return new Pair(node, right.index);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);

        Codec_37 codec_37 = new Codec_37();
        System.out.println(codec_37.serialize(node));
        System.out.println(codec_37.deserialize(codec_37.serialize(node)));
    }
}

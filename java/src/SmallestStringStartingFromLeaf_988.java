public class SmallestStringStartingFromLeaf_988 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private String res = null;

    public char transformToCharacter(int val) {
        return (char) (val + 97);
    }

    public String smallestFromLeaf(TreeNode root) {
        recursion(root, "");
        return this.res;
    }

    public void recursion(TreeNode node, String cur) {
        if (node.left == null && node.right == null) {
            cur = transformToCharacter(node.val) + cur;
            if (res == null || cur.compareTo(res) < 0)
                this.res = cur;
            return;
        }
        if (node.left != null) {
            recursion(node.left, transformToCharacter(node.val) + cur);
        }
        if (node.right != null) {
            recursion(node.right, transformToCharacter(node.val) + cur);
        }
    }

    public static void main(String[] args) {

    }
}

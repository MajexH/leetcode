public class IsSubStructure_26 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 判断 b 是不是 a 的子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;

        return (A.val == B.val && check(A, B))
                || isSubStructure(A.left, B)
                || isSubStructure(A.right, B);
    }

    // 这个子结构是指 只要是数字相同即可
    public boolean check(TreeNode node1, TreeNode node2) {
        if (node2 == null) return true;
        if (node1 == null) return false;

        return node1.val == node2.val &&
                check(node1.left, node2.left) &&
                check(node1.right, node2.right);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        a.left = new TreeNode(1);

        TreeNode b = new TreeNode(2);
        b.left = new TreeNode(1);
        b.right = new TreeNode(2);

        System.out.println(new IsSubStructure_26().check(a, b));
    }

}

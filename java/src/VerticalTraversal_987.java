import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VerticalTraversal_987 {
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

    private static class Pair {
        int row;
        int val;

        public Pair(int row, int val) {
            this.row = row;
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, List<Pair>> tmp = new HashMap<>();
        recursion(root, 0, 0, tmp);

        // col 排序
        List<Integer> keys = tmp.keySet().stream().sorted().collect(Collectors.toList());
        // col 排序后 对 每一行里面的数据排序
        for (Integer key : keys) {
            List<Pair> cols = tmp.get(key);
            cols.sort((c1, c2) -> {
                if (c1.row == c2.row) {
                    return c1.val - c2.val;
                }
                return c1.row - c2.row;
            });
            res.add(cols.stream().map(Pair::getVal).collect(Collectors.toList()));
        }
        return res;
    }

    private void recursion(TreeNode node, int row, int col, Map<Integer, List<Pair>> tmp) {
        if (node == null) {
            return;
        }
        if (!tmp.containsKey(col)) {
            tmp.put(col, new ArrayList<>());
        }
        tmp.get(col).add(new Pair(row, node.val));
        recursion(node.left, row + 1, col - 1, tmp);
        recursion(node.right, row + 1, col + 1, tmp);
    }
}

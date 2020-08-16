import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateBST_95 {
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

    public List<TreeNode> recursion(int start, int end, Map<String, List<TreeNode>> memo) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        String key = start + "-" + end;
        if (memo.containsKey(key)) return memo.get(key);
        for (int i = start; i <= end; i++) {
            // 去遍历之后生成的左子树和右子树
            for (TreeNode left : recursion(start, i - 1, memo)) {
                for (TreeNode right : recursion(i + 1, end, memo)) {
                    res.add(new TreeNode(i, left, right));
                }
            }
        }
        memo.put(key, res);
        return res;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return recursion(1, n, new HashMap<>());
    }

    public static void main(String[] args) {
        System.out.println(new GenerateBST_95().generateTrees(1));
    }
}

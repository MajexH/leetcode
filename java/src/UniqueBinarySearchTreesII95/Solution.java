package UniqueBinarySearchTreesII95;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 跟96题基本上是一样的
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
//        return recursion(1, n);
        return recursionWithMemo(1, n, new HashMap<>());
    }

    // start end表示需要生成BST的数字区间
    public List<TreeNode> recursion(int start, int end) {
        List<TreeNode> temp = new ArrayList<>();
        if (start > end) {
            temp.add(null);
            return temp;
        }
        for (int i = start; i <= end; i++) {
            // 分别取找当前的i下的left和right
            // 因为选取一个i去做当前recursion的根节点的时候 其左右子树会有不同的情况 所以需要一个数据接口来保存所有的情况并返回
            List<TreeNode> lefts = recursion(start, i - 1);
            List<TreeNode> rights = recursion(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    temp.add(node);
                }
            }
        }
        return temp;
    }

    public List<TreeNode> recursionWithMemo(int start, int end, Map<String, List<TreeNode>> memo) {
        if (memo.containsKey(start + "-" + end)) {
            return memo.get(start + "-" + end);
        }
        List<TreeNode> temp = new ArrayList<>();
        if (start > end) {
            temp.add(null);
            memo.put(start + "-" + end, temp);
            return temp;
        }
        for (int i = start; i <= end; i++) {
            // 分别取找当前的i下的left和right
            // 因为选取一个i去做当前recursion的根节点的时候 其左右子树会有不同的情况 所以需要一个数据接口来保存所有的情况并返回
            List<TreeNode> lefts = recursionWithMemo(start, i - 1, memo);
            List<TreeNode> rights = recursionWithMemo(i + 1, end, memo);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    temp.add(node);
                }
            }
        }
        memo.put(start + "-" + end, temp);
        return memo.get(start + "-" + end);
    }
}

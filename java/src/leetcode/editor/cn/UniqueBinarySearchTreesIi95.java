package leetcode.editor.cn;//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// 
// 
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 👍 1238 👎 0


import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesIi95 {
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

    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi95().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {

        private List<TreeNode> recursion(int start, int end, List<Integer> numbers) {
            List<TreeNode> res = new ArrayList<>();

            if (start > end) {
                res.add(null);
                return res;
            }

            for (int i = start; i <= end; i++) {
                List<TreeNode> lefts = this.recursion(start, i - 1, numbers);
                List<TreeNode> rights = this.recursion(i + 1, end, numbers);

                for (TreeNode left : lefts) {
                    for (TreeNode right : rights) {
                        res.add(new TreeNode(numbers.get(i), left, right));
                    }
                }
            }

            return res;
        }

        public List<TreeNode> generateTrees(int n) {
            if (n <= 0) {
                return new ArrayList<>();
            }

            List<Integer> nums = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                nums.add(i);
            }

            return this.recursion(0, n - 1, nums);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
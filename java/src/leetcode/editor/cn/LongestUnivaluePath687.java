//给定一个二叉树的
// root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。 
//
// 两个节点之间的路径长度 由它们之间的边数表示。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,4,5,1,1,5]
//输出：2
// 
//
// 示例 2: 
//
// 
//
// 
//输入：root = [1,4,5,4,4,5]
//输出：2
// 
//
// 
//
// 提示: 
//
// 
// 树的节点数的范围是
// [0, 10⁴] 
// -1000 <= Node.val <= 1000 
// 树的深度将不超过 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 722 👎 0


package leetcode.editor.cn;

import java.util.Objects;

public class LongestUnivaluePath687 {
    public static void main(String[] args) {
        Solution solution = new LongestUnivaluePath687().new Solution();

        TreeNode node = new TreeNode(1);
        node.left = null;
        node.right = new TreeNode(1);
        node.right.left = new TreeNode(1);
        node.right.right = new TreeNode(1);
        node.right.left.left = new TreeNode(1);
        node.right.left.right = new TreeNode(1);
        node.right.right.left = new TreeNode(1);

        System.out.println(solution.longestUnivaluePath(node));

    }

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

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        private int res = 1;

        public int longestUnivaluePath(TreeNode root) {
            if (Objects.isNull(root)) {
                return 0;
            }

            this.res = 0;
            this.postOrderTravel(root);
            return this.res - 1;
        }

        private int postOrderTravel(TreeNode node) {
            if (Objects.isNull(node)) {
                return 0;
            }
            int left = this.postOrderTravel(node.left);
            int right = this.postOrderTravel(node.right);

            Integer leftVal = Objects.isNull(node.left) ? null : node.left.val;
            Integer rightVal = Objects.isNull(node.right) ? null : node.right.val;

            // 左右 和 node 都一样 说明可以累加
            if (Objects.equals(leftVal, rightVal) && Objects.equals(leftVal, node.val)) {
                res = Math.max(res, left + right + 1);
                // 返回的只能是相等的结点多的那一条
                return Math.max(left, right) + 1;
            }

            // 如果其中一个跟 node 相同
            if (Objects.equals(leftVal, node.val)) {
                res = Math.max(res, left + 1);
                return left + 1;
            }
            if (Objects.equals(rightVal, node.val)) {
                res = Math.max(res, right + 1);
                return right + 1;
            }
            res = Math.max(res, 1);
            // 绝对不相等
            return 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
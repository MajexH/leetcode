//给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。
//
// 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。(移动可以是从父结点到子结点，或者从子结点移动到父结点。)。 
//
// 返回使每个结点上只有一枚硬币所需的移动次数。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[3,0,0]
//输出：2
//解释：从树的根结点开始，我们将一枚硬币移到它的左子结点上，一枚硬币移到它的右子结点上。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,3,0]
//输出：3
//解释：从根结点的左子结点开始，我们将两枚硬币移到根结点上 [移动两次]。然后，我们把一枚硬币从根结点移到右子结点上。
// 
//
// 示例 3： 
//
// 
//
// 输入：[1,0,2]
//输出：2
// 
//
// 示例 4： 
//
// 
//
// 输入：[1,0,0,null,3]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1<= N <= 100 
// 0 <= node.val <= N 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 424 👎 0

package leetcode.editor.cn;

import java.util.Objects;

public class DistributeCoinsInBinaryTree_979 {

    public static void main(String[] args) {
        Solution solution = new DistributeCoinsInBinaryTree_979().new Solution();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);

        System.out.println(solution.distributeCoins(root));
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

        int res = 0;

        public int distributeCoins(TreeNode root) {
            this.res = 0;

            this.dfs(root);

            return this.res;
        }

        private int dfs(TreeNode node) {

            if (Objects.isNull(node)) {
                return 0;
            }

            int left = this.dfs(node.left);
            int right = this.dfs(node.right);

            this.res += Math.abs(left) + Math.abs(right);
            return left + right + node.val - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 647 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;


public class KthSmallestElementInABst230 {
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInABst230().new Solution();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.left.right = new TreeNode(2);
        System.out.println(solution.kthSmallest(node, 1));
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

        public int kthSmallest(TreeNode root, int k) {
            Deque<TreeNode> stack = new LinkedList<>();

            while (stack.size() > 0 || root != null) {
                while (root != null) {
                    stack.addLast(root);
                    root = root.left;
                }

                if (stack.size() > 0) {
                    // 中序遍历
                    root = stack.removeLast();
                    k--;
                    if (k == 0) {
                        return root.val;
                    }
                    root = root.right;
                }
            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
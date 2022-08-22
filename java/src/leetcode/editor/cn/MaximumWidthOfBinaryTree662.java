//给你一棵二叉树的根节点 root ，返回树的 最大宽度 。 
//
// 树的 最大宽度 是所有层中最大的 宽度 。 
//
// 
// 
// 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 
//null 节点，这些 null 节点也计入长度。 
//
// 题目数据保证答案将会在 32 位 带符号整数范围内。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,2,5,3,null,9]
//输出：4
//解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,3,2,5,null,null,9,6,null,7]
//输出：7
//解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,3,2,5]
//输出：2
//解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [1, 3000] 
// -100 <= Node.val <= 100 
// 
// 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 405 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class MaximumWidthOfBinaryTree662 {
    public static void main(String[] args) {
        Solution solution = new MaximumWidthOfBinaryTree662().new Solution();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(3);
        node.right.right = new TreeNode(9);
        System.out.println(solution.widthOfBinaryTree(node));
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

        private static class TreeNodeWrapper {
            private TreeNode treeNode;
            private int index;

            public TreeNodeWrapper(TreeNode treeNode, int index) {
                this.treeNode = treeNode;
                this.index = index;
            }
        }

        public int widthOfBinaryTree(TreeNode root) {

            if (root == null) {
                return 0;
            }

            int res = 1;

            Deque<TreeNodeWrapper> queue = new LinkedList<>();
            queue.addLast(new TreeNodeWrapper(root, 1));
            queue.addLast(null);

            while (!queue.isEmpty()) {
                TreeNodeWrapper top = queue.removeFirst();

                if (top == null) {

                    if (queue.isEmpty()) {
                        break;
                    }
                    // 给每个节点编号 那么只需要知道每一层的最大编号和最小编号即可
                    res = Math.max(res, queue.getLast().index - queue.getFirst().index + 1);
                    // 当前层次已经访问完毕 而且把下一层次的子节点添加完毕
                    queue.addLast(null);
                    continue;
                }

                if (top.treeNode.left != null) {
                    queue.addLast(new TreeNodeWrapper(top.treeNode.left, 2 * top.index + 1));
                }

                if (top.treeNode.right != null) {
                    queue.addLast(new TreeNodeWrapper(top.treeNode.right, 2 * top.index + 2));
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.cn;//完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
//
// 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。 
//
// 实现 CBTInserter 类: 
//
// 
// CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构； 
// CBTInserter.insert(int v) 向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态
//，并返回插入节点 TreeNode 的父节点的值； 
// CBTInserter.get_root() 将返回树的头节点。 
// 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//
// 
//输入
//["CBTInserter", "insert", "insert", "get_root"]
//[[[1, 2]], [3], [4], []]
//输出
//[null, 1, 2, [1, 2, 3, 4]]
//
//解释
//CBTInserter cBTInserter = new CBTInserter([1, 2]);
//cBTInserter.insert(3);  // 返回 1
//cBTInserter.insert(4);  // 返回 2
//cBTInserter.get_root(); // 返回 [1, 2, 3, 4] 
//
// 
//
// 提示： 
//
// 
// 树中节点数量范围为 [1, 1000] 
// 0 <= Node.val <= 5000 
// root 是完全二叉树 
// 0 <= val <= 5000 
// 每个测试用例最多调用 insert 和 get_root 操作 10⁴ 次 
// 
// Related Topics 树 广度优先搜索 设计 二叉树 👍 131 👎 0


import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class CompleteBinaryTreeInserter919 {
    public static void main(String[] args) {
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

    class CBTInserter {

        private TreeNode root;
        private int depth;

        public CBTInserter(TreeNode root) {
            this.root = root;
            this.depth = this.getDepth(root);
        }

        public int insert(int val) {
            // 初始化根节点
            if (Objects.isNull(root)) {
                root = new TreeNode(val);
                return -1;
            }
            this.depth = this.getDepth(this.root);
            int curDepth = 0;
            // 在根节点不为空的情况下插入
            // 层次遍历到倒数第二层 看哪个节点的下一层为空
            Deque<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            queue.addLast(null);
            while (!queue.isEmpty()) {
                TreeNode head = queue.removeFirst();
                if (head == null) {
                    if (queue.size() == 0) {
                        break;
                    }
                    queue.addLast(null);
                    curDepth++;
                    continue;
                }

                if (head.left != null) {
                    queue.addLast(head.left);
                }
                if (head.right != null) {
                    queue.addLast(head.right);
                }

                if (curDepth == this.depth - 1) {
                    if (head.left == null) {
                        head.left = new TreeNode(val);
                        return head.val;
                    }
                    if (head.right == null) {
                        head.right = new TreeNode(val);
                        return head.val;
                    }
                }
            }
            return -1;
        }

        public TreeNode get_root() {
            return root;
        }

        private int getDepth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return Math.max(this.getDepth(node.left), this.getDepth(node.right)) + 1;
        }
    }

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
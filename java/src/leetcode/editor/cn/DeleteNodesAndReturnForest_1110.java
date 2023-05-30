//给出二叉树的根节点 root，树上每个节点都有一个不同的值。
//
// 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。 
//
// 返回森林中的每棵树。你可以按任意顺序组织答案。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
//输出：[[1,2,null,4],[6],[7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,4,null,3], to_delete = [3]
//输出：[[1,2,4]]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数最大为 1000。 
// 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。 
// to_delete.length <= 1000 
// to_delete 包含一些从 1 到 1000、各不相同的值。 
// 
//
// Related Topics 树 深度优先搜索 数组 哈希表 二叉树 👍 242 👎 0


package src.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class DeleteNodesAndReturnForest_1110 {
    public static void main(String[] args) {
        Solution solution = new DeleteNodesAndReturnForest_1110().new Solution();

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        System.out.println(solution.delNodes(node, new int[]{3, 5}));


        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.left.left = new TreeNode(4);
        node1.left.right = new TreeNode(3);

        System.out.println(solution.delNodes(node1, new int[]{2, 3}));


        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        node2.right = new TreeNode(3);
        node2.right.right = new TreeNode(4);

        System.out.println(solution.delNodes(node2, new int[]{2, 1}));
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

            Set<Integer> toDeleteTreeNodes = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());

            // 然后删除某些点 成为树林
            List<TreeNode> res = new ArrayList<>();
            if (!toDeleteTreeNodes.contains(root.val)) {
                res.add(root);
            }

            this.dfs(root, null, false, toDeleteTreeNodes, res);

            return res;
        }

        // 前序遍历
        private void dfs(TreeNode node, TreeNode parent, boolean isLeft, Set<Integer> toDeleteTreeNodes, List<TreeNode> res) {

            if (Objects.isNull(node)) {
                return;
            }

            // 不需要删除的话 说明现在还在某一棵树上
            if (!toDeleteTreeNodes.contains(node.val)) {
                // 分别遍历左右
                this.dfs(node.left, node, true, toDeleteTreeNodes, res);
                this.dfs(node.right, node, false, toDeleteTreeNodes, res);
                return;
            }

            // 删除的节点需要处理
            // 需要把父节点的关联关系删除
            if (Objects.nonNull(parent)) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }

            TreeNode left = node.left;
            TreeNode right = node.right;
            // 删除左右子节点的关系
            node.left = null;
            node.right = null;
            // 说明左右节点是单独的树
            if (Objects.nonNull(left) && !toDeleteTreeNodes.contains(left.val)) {
                res.add(left);
            }
            if (Objects.nonNull(right) && !toDeleteTreeNodes.contains(right.val)) {
                res.add(right);
            }

            this.dfs(left, node, true, toDeleteTreeNodes, res);
            this.dfs(right, node, false, toDeleteTreeNodes, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
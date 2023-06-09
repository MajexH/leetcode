//给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个 [0, 25] 范围内的值，分别代表字母 'a' 到 'z'。
//
// 返回 按字典序最小 的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。 
//
// 
// 注：字符串中任何较短的前缀在 字典序上 都是 较小 的： 
// 
//
// 
// 例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。 
// 
//
// 节点的叶节点是没有子节点的节点。 
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
//输入：root = [0,1,2,3,4,3,4]
//输出："dba"
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [25,1,3,1,3,0,2]
//输出："adz"
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [2,2,1,null,1,0,null,0]
//输出："abc"
// 
//
// 
//
// 提示： 
//
// 
// 给定树的结点数在 [1, 8500] 范围内 
// 0 <= Node.val <= 25 
// 
//
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 101 👎 0


package src.leetcode.editor.cn;

import java.util.Objects;

public class SmallestStringStartingFromLeaf_988 {
    public static void main(String[] args) {
        Solution solution = new SmallestStringStartingFromLeaf_988().new Solution();
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

        private String tmp = null;

        public String smallestFromLeaf(TreeNode root) {

            this.tmp = null;

            if (Objects.isNull(root)) {
                return null;
            }

            this.recursion(root, "");

            return this.tmp;
        }

        private void recursion(TreeNode node, String str) {

            String cur = (char) (node.val + 'a') + str;
            if (Objects.isNull(node.left) && Objects.isNull(node.right)) {

                if (Objects.isNull(this.tmp)) {
                    this.tmp = cur;
                    return;
                }

                if (cur.compareTo(this.tmp) < 0) {
                    this.tmp = cur;
                }
                return;
            }

            if (Objects.nonNull(node.left)) {
                this.recursion(node.left, cur);
            }
            if (Objects.nonNull(node.right)) {
                this.recursion(node.right, cur);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
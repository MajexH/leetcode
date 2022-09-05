//给定一棵二叉树 root，返回所有重复的子树。 
//
// 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,null,2,4,null,null,4]
//输出：[[2,4],[4]] 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,1]
//输出：[[1]] 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [2,2,2,3,null,3,null]
//输出：[[2,3],[3]] 
//
// 
//
// 提示： 
//
// 
// 树中的结点数在[1,10^4]范围内。 
// -200 <= Node.val <= 200 
// 
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 555 👎 0


package leetcode.editor.cn;

import java.util.*;

public class FindDuplicateSubtrees652 {
    public static void main(String[] args) {
        Solution solution = new FindDuplicateSubtrees652().new Solution();
    }
    
    private static class TreeNode {
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

        private List<TreeNode> res = new ArrayList<>();

        // 这样实现的方案是对子树进行编码来实现的
        public List<TreeNode> findDuplicateSubtreesUsingEncode(TreeNode root) {
            res = new ArrayList<>();
            this.postOrder(root, new HashMap<>(), new HashSet<>());
            return res;
        }

        private String postOrder(TreeNode node, Map<String, TreeNode> memo, Set<String> added) {
            if (Objects.isNull(node)) {
                return "null";
            }

            String left = this.postOrder(node.left, memo, added);
            String right = this.postOrder(node.right, memo, added);

            String cur = node.val + "-left" + left + " right" + right;

            if (memo.containsKey(cur)) {
                if (!added.contains(cur)) {
                    res.add(node);
                    added.add(cur);
                }
            } else {
                memo.put(cur, node);
            }

            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
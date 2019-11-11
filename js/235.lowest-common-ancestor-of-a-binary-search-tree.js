/*
 * @lc app=leetcode id=235 lang=javascript
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */


function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

// @lc code=start
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
  if (Math.min(p.val, q.val) > root.val) {
    return lowestCommonAncestor(root.right, p, q)
  } else if (Math.max(p.val, q.val) < root.val) {
    return lowestCommonAncestor(root.left, p, q)
  } else {
    return root
  }
};
// @lc code=end

let root = new TreeNode(6)
root.left = new TreeNode(2)
root.left.left = new TreeNode(0)
root.left.right = new TreeNode(4)
root.left.right.left = new TreeNode(3)
root.left.right.right = new TreeNode(5)

root.right = new TreeNode(8)
root.right.left = new TreeNode(7)
root.right.right = new TreeNode(9)

console.log(lowestCommonAncestor(root, root.left, root.right))

console.log(lowestCommonAncestor(root, root.left, root.left.right))
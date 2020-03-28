/*
 * @lc app=leetcode id=144 lang=javascript
 *
 * [144] Binary Tree Preorder Traversal
 */

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

// @lc code=start

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal = function(root) {
  let stack = [], res = []
  while (root || stack.length !== 0) {
    while (root) {
      stack.push(root)
      res.push(root.val)
      root = root.left
    }
    if (stack.length !== 0) {
      root = stack.pop()
      root = root.right
    }
  }
  return res
};
// @lc code=end

let root = new TreeNode(1)
root.right = new TreeNode(3)
root.left = new TreeNode(2)
// root.left.left = new TreeNode(4)
// root.left.right = new TreeNode(5)
// root.right.left = new TreeNode(6)
// root.right.right = new TreeNode(7)

console.log(preorderTraversal(root))
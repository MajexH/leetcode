/*
 * @lc app=leetcode id=94 lang=javascript
 *
 * [94] Binary Tree Inorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function(root) {
  let stack = [], res = []
  while (root || stack.length !== 0) {
    while (root) {
      stack.push(root)
      root = root.left
    }
    if (stack.length !== 0) {
      root = stack.pop()
      res.push(root.val)
      root = root.right
    }
  }
  return res
};
// @lc code=end


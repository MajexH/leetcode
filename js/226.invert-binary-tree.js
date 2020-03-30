/*
 * @lc app=leetcode id=226 lang=javascript
 *
 * [226] Invert Binary Tree
 */

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

// @lc code=start

/**
 * 其实先序遍历即可
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function(root) {
  let stack = [], record = root
  while (root || stack.length !== 0) {
    while (root) {
      stack.push(root)
      let temp = root.left
      root.left = root.right
      root.right = temp
      root = root.left
    }
    if (stack.length !== 0) {
      root = stack.pop()
      root = root.right
    }
  }
  return record
};
// @lc code=end


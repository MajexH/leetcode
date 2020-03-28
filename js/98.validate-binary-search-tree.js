/*
 * @lc app=leetcode id=98 lang=javascript
 *
 * [98] Validate Binary Search Tree
 */

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

// @lc code=start

/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function(root) {
  let stack = [], pre = null
  while (root || stack.length !== 0) {
    while (root) {
      stack.push(root)
      root = root.left
    }
    if (stack.length !== 0) {
      root = stack.pop()
      // 中序
      if (pre !== null && pre >= root.val) return false
      pre = root.val
      root = root.right
    }
  }
  return true
};

// @lc code=end

let root = new TreeNode(5)
root.left = new TreeNode(1)
// root.right = new TreeNode(4)
// root.right.left = new TreeNode(3)
// root.right.right = new TreeNode(6)

console.log(isValidBST(root))
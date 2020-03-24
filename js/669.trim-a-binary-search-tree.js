/*
 * @lc app=leetcode id=669 lang=javascript
 *
 * [669] Trim a Binary Search Tree
 */

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

// @lc code=start
/**
 * @param {TreeNode} root
 * @param {number} L
 * @param {number} R
 * @return {TreeNode}
 */
var trimBST = function(root, L, R) {
  return recursion(root, L, R)
};

function recursion(node, L, R) {
  if (!node) return node
  // 左边和自己都不能要了
  if (node.val < L) {
    // 这样就去判断右边是否满足要求
    return recursion(node.right, L, R)
  }
  // 右边和自己都不能要了
  if (node.val > R) {
    // 判断左边是否满足要求
    return recursion(node.left, L, R)
  }
  node.left = recursion(node.left, L, R)
  node.right = recursion(node.right, L, R)
  return node
}
// @lc code=end


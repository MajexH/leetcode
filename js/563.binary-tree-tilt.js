/*
 * @lc app=leetcode id=563 lang=javascript
 *
 * [563] Binary Tree Tilt
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
let res = 0
/**
 * @param {TreeNode} root
 * @return {number}
 */
var findTilt = function(root) {
  res = 0
  afterOrderTravel(root)
  return res
};


function afterOrderTravel(node) {
  if (!node) return 0
  let left = afterOrderTravel(node.left)
  let right = afterOrderTravel(node.right)
  res += Math.abs(left - right)
  return node.val + left + right
}
// @lc code=end


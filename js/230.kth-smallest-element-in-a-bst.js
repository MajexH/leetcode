/*
 * @lc app=leetcode id=230 lang=javascript
 *
 * [230] Kth Smallest Element in a BST
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(root, k) {
  if (!root) return 0
  return recursion(root, k)
};

function recursion(root, k) {
  let left = getCount(root.left) + 1
  if (left > k) {
    return recursion(root.left, k)
  } else if (left < k) {
    return recursion(root.right, k - left)
  } else {
    return root.val
  }
}

function getCount(root) {
  if (!root) return 0
  return getCount(root.left) + getCount(root.right) + 1
}
// @lc code=start
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(root, k) {
  // inorder travel
  let stack = []
  while (root || stack.length !== 0) {
    while (root) {
      stack.push(root)
      root = root.left
    }
    if (stack.length !== 0) {
      root = stack.pop()
      k--
      if (k === 0) return root.val
      root = root.right
    }
  }
  return null
};
// @lc code=end


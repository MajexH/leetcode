/*
 * @lc app=leetcode id=236 lang=javascript
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

let res = null
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor1 = function(root, p, q) {
  res = null
  recursion(root, p, q)
  return res
};

function recursion(root, p, q) {
  if (!root) return false

  let left = recursion(root.left, p, q) ? 1 : 0
  let right = recursion(root.right, p, q) ? 1 : 0
  let mid = (root === p || root === q) ? 1 : 0
  if (left + right + mid >= 2) {
    res = root
  }
  return left + right + mid > 0
}

// @lc code=start
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
  let parent = new Map(), stack = [root]
  parent.set(root, null)
  while ((!parent.has(p) || !parent.has(q)) && stack.length > 0) {
    let top = stack.pop()
    if (top.left) {
      parent.set(top.left, top)
      stack.push(top.left)
    }
    if (top.right) {
      parent.set(top.right, top)
      stack.push(top.right)
    }
  }
  let parentChain = new Set()
  while (p !== null) {
    parentChain.add(p)
    p = parent.get(p)
  }
  while (!parentChain.has(q)) {
    q = parent.get(q)
  }
  return q
};
// @lc code=end
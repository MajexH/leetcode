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
  let parents = new Map()
  let stack = [root]
  parents.set(root, null)
  // 找到p q
  while (!parents.has(p) || !parents.has(q)) {
    let top = stack.pop()
    if (top.left) {
      parents.set(top.left, top)
      stack.push(top.left)
    }
    if (top.right) {
      parents.set(top.right, top)
      stack.push(top.right)
    }
  }
  // 构建p的祖先链
  let ancestors = new Set()
  while (p !== null) {
    ancestors.add(p)
    p = parents.get(p)
  }
  // q在祖先链中第一个找到的祖先 就公共最小祖先
  while (!ancestors.has(q)) {
    q = parents.get(q)
  }
  return q 
};
// @lc code=end


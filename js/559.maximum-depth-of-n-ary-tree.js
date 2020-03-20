/*
 * @lc app=leetcode id=559 lang=javascript
 *
 * [559] Maximum Depth of N-ary Tree
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number}
 */
var maxDepth = function(root) {
  return recursion(root)
};

/**
 * 
 * @param {Node} node 
 */
function recursion(node) {
  if (!node) return 0
  let max = 0
  for (let child of node.children) {
    max = Math.max(max, recursion(child))
  }
  return max + 1;
}
// @lc code=end


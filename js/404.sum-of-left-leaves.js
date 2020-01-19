/*
 * @lc app=leetcode id=404 lang=javascript
 *
 * [404] Sum of Left Leaves
 */

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

// @lc code=start
/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumOfLeftLeaves = function(root) {
  return recursion(root, false)
};

/**
 * 
 * @param {TreeNode} node 
 * @param {boolean} flag 
 */
function recursion(node, flag) {
  if (!node) return 0
  if (!node.left && !node.right) {
    if (flag) return node.val
    else return 0
  }
  return recursion(node.left, true) + recursion(node.right, false)
}
// @lc code=end

let root = new TreeNode(3)
root.left = new TreeNode(9)
root.right = new TreeNode(20)
root.right.left = new TreeNode(15)
root.right.right = new TreeNode(7)

console.log(sumOfLeftLeaves(root))
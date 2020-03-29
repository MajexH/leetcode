/*
 * @lc app=leetcode id=105 lang=javascript
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 */

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

// @lc code=start
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
  return recursion(preorder, inorder)
};

/**
 * 
 * @param {number[]} preorder
 * @param {number[]} inorder
 */
function recursion(preorder, inorder) {
  if (preorder.length === 0 || inorder.length === 0) return null
  let rootVal = preorder[0]
  let root = new TreeNode(rootVal)
  let index = inorder.findIndex((val) => val === rootVal)
  root.left = recursion(preorder.slice(1, 1 + index), inorder.slice(0, index))
  root.right = recursion(preorder.slice(1 + index), inorder.slice(index + 1))
  return root
}
// @lc code=end

console.log(buildTree([3,9,20,15,7], [9,3,15,20,7]))
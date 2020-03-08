/*
 * @lc app=leetcode id=530 lang=javascript
 *
 * [530] Minimum Absolute Difference in BST
 */

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

// @lc code=start
let res = Number.MAX_SAFE_INTEGER
// 保存前一个节点的值
let pre = null
/**
 * 中序遍历是递增的 就是找递增数列中 相邻两个数的最小值
 * @param {TreeNode} root
 * @return {number}
 */
var getMinimumDifference = function(root) {
  res = Number.MAX_SAFE_INTEGER
  pre = null
  recursion(root)
  return res
};

function recursion(root) {
  if (!root) return 
  recursion(root.left)
  if (pre !== null) {
    res = Math.min(res, root.val - pre)
  }
  pre = root.val
  recursion(root.right)
}
// @lc code=end

let root = new TreeNode(236)
root.left = new TreeNode(104)
root.left.right = new TreeNode(227)
root.right = new TreeNode(701)
root.right.right = new TreeNode(911)

console.log(getMinimumDifference(root))
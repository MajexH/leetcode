/*
 * @lc app=leetcode id=337 lang=javascript
 *
 * [337] House Robber III
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
var rob = function(root) {
  let res = recursion(root)
  return Math.max(res[0], res[1])
};

function recursion(node) {
  let res = [0, 0]
  if (!node) return res
  let left = recursion(node.left)
  let right = recursion(node.right)
  // res[0] 表示不拿这个点 那么其子节点就可以获取 或者 不拿
  // 因此 取最大值即可
  res[0] = Math.max(...left) + Math.max(...right)
  // 表示拿这个点 那么最大值的就是 子节点都不拿 
  res[1] = node.val + left[0] + right[0]
  return res
}
// @lc code=end

let root = new TreeNode(2)
root.left = new TreeNode(1)
root.right = new TreeNode(3)
// root.left.left = new TreeNode(3)
root.left.right = new TreeNode(4)

console.log(rob(root))
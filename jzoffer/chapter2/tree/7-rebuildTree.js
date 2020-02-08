const { TreeNode } = require('./tree.js');

/**
 * 
 * @param {Array} pre 前序遍历数组 
 * @param {Array} inOrder 中序遍历数组
 */
function rebuildTree(pre, inOrder) {
  return recursion(pre, inOrder)
}

/**
 * 
 * @param {Array} pre 
 * @param {Array} inOrder 
 */
function recursion(pre, inOrder) {
  if (pre.length === 0 || inOrder.length === 0) return null
  let root = new TreeNode()
  root.val = pre.shift()
  let index = inOrder.findIndex((val) => val === root.val)
  root.left = recursion(pre.slice(0, index), inOrder.slice(0, index))
  root.right = recursion(pre.slice(index), inOrder.slice(index + 1))
  return root
}

console.log(rebuildTree([1,2,4,7,3,5,6,8], [4,7,2,1,5,3,8,6]))
console.log(1)
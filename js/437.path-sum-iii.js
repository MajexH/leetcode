/*
 * @lc app=leetcode id=437 lang=javascript
 *
 * [437] Path Sum III
 */

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

// @lc code=start
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {number}
 */
var pathSum = function(root, sum) {
  let count = { res: 0 }
  recursion(root, [], count, sum)
  return count.res
};

/**
 * 
 * @param {TreeNode} node 
 * @param {Array} array 保存所有的到现在的值
 * @param {Object} count 代表这一支上的数
 * @param {Number} target 目标和
 */
function recursion(node, array, count, target) {
  if (node === null) {
    return
  }
  for (let i = 0; i < array.length; i++) {
    if (target === node.val + array[i]) count.res++
    array[i] = array[i] + node.val
  }
  if (node.val === target) count.res++
  array.push(node.val)
  recursion(node.left, [...array], count, target)
  recursion(node.right, [...array], count, target)
}
// @lc code=end

let root = new TreeNode(10)
// root.left = new TreeNode(5)
// root.right = new TreeNode(-3)

// root.left.left = new TreeNode(3)
// root.left.right = new TreeNode(2)

// root.left.left.left = new TreeNode(3)
// root.left.left.right = new TreeNode(-2)
// root.left.right.right = new TreeNode(1)

// root.right.right = new TreeNode(11)

console.log(pathSum(root, 10))
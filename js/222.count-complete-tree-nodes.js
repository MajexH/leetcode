/*
 * @lc app=leetcode id=222 lang=javascript
 *
 * [222] Count Complete Tree Nodes
 */

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 * @return {number}
 */
var countNodes1 = function(root) {
  if (root === null) {
    return 0
  }
  return countNodes(root.left) + countNodes(root.right) + 1
};


// @lc code=start
/**
 * 二分是基于这样的思想
 * 比较两个子树的高度 如果高度不同 则右子树肯定有缺 然后不停的递归即可
 * 左子树的节点数跟高度有关
 * @param {TreeNode} root
 * @return {number}
 */
var countNodes = function(root) {
  return recursion(root, 0, 0)
};

function recursion(root, left, right) {
	if (!root) return 0
  let lright = 0

  let node = root
  if (left === 0)
    while (node) {
      left++
      node = node.left
    }

  node = root
  if (right === 0)
    while (node) {
      right++
      node = node.right
    }

  if (left === right) {
    return (1 << left) - 1
  }

  node = root.left
  while (node) {
    lright++
    node = node.right
	}
  // 左子树不满
  if (left - 1 !== lright) {
    return (1 << (right - 1)) + recursion(root.left, left - 1, lright)
  } else {
    return (1 << (left - 1)) + recursion(root.right, 0, right - 1)
  }
}
// @lc code=end

let root = new TreeNode(1)
root.left = new TreeNode(2)
root.right = new TreeNode(3)
root.left.left = new TreeNode(4)
root.left.right = new TreeNode(5)
root.right.left = new TreeNode(6)

console.log(countNodes(root))
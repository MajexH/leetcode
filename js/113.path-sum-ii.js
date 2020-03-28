/*
 * @lc app=leetcode id=113 lang=javascript
 *
 * [113] Path Sum II
 */

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

// @lc code=start

/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {number[][]}
 */
var pathSum = function(root, sum) {
  let res = []
  if (!root) return res
  recursion(root, sum, [], res)
  return res
};

function recursion(root, target, temp, res) {
  if (!root.left && !root.right) {
    if (target === root.val) {
      res.push([...temp, root.val])
    }
    return
  }
  temp.push(root.val)
  if (root.left)
    recursion(root.left, target - root.val, temp, res)
  if (root.right)
    recursion(root.right, target - root.val, temp, res)
  temp.pop()
}
// @lc code=end


let treeNode = new TreeNode(5)
treeNode.left = new TreeNode(4)
treeNode.right = new TreeNode(8)
treeNode.left.left = new TreeNode(11)
treeNode.left.left.left = new TreeNode(7)
treeNode.left.left.right = new TreeNode(2)
treeNode.right.left = new TreeNode(13)
treeNode.right.right = new TreeNode(4)
treeNode.right.right.right = new TreeNode(1)

console.log(pathSum(treeNode, 22))
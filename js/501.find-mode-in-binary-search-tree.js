/*
 * @lc app=leetcode id=501 lang=javascript
 *
 * [501] Find Mode in Binary Search Tree
 */

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

// @lc code=start
let res = []
let currentLength = 0, max = 0
let currentValue = null
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var findMode = function(root) {
  if (!root) return []
  res = []
  currentLength = 0
  max = 0
  currentValue = null
  recursion(root)
  if (currentLength > max) {
    res = [currentValue]
  } else if (currentLength === max){
    res.push(currentValue)
  }
  return res
};

/**
 * 基于中序遍历来的 每次保存前一个数的结果 然后跟之后的比较
 * @param {TreeNode} root 
 */
function recursion(root) {
  if (!root) return
  recursion(root.left)
  if (currentValue === null) {
    currentValue = root.val
    currentLength = 1
  }
  // 说明已经进入到下一个的数的范围里面了
  else if (root.val !== currentValue) {
    if (currentLength === max) {
      // 更新res
      res.push(currentValue)
    } else if (currentLength > max) {
      res = [currentValue]
      max = currentLength
    }
    // 因为已经到下一个位置了
    currentLength = 1
    currentValue = root.val
  } else {
    currentLength++
  }

  recursion(root.right)
}
// @lc code=end

let root = new TreeNode(6)
root.left = new TreeNode(2)
root.right = new TreeNode(8)
root.left.left = new TreeNode(0)
root.left.right = new TreeNode(4)
root.left.right.left = new TreeNode(2)
root.left.right.right = new TreeNode(6)
root.right.left = new TreeNode(7)
root.right.right = new TreeNode(9)

console.log(findMode(root))
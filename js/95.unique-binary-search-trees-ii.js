/*
 * @lc app=leetcode id=95 lang=javascript
 *
 * [95] Unique Binary Search Trees II
 */

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

// @lc code=start

/**
 * @param {number} n
 * @return {TreeNode[]}
 */
var generateTrees = function(n) {
  if (n === 0) return []
  return recursion(1, n)
};

function recursion(start, end) {
  let res = []
  if (start > end) {
    res.push(null)
    return res
  }
  // 分割点
  for (let i = start; i <= end; i++) {
    let lefts = recursion(start, i - 1), rights = recursion(i + 1, end)
    for (let left of lefts) {
      for (let right of rights) {
        let node = new TreeNode(i)
        node.left = left
        node.right = right
        res.push(node)
      }
    }
  }
  return res
}
// @lc code=end

console.log(generateTrees(3))
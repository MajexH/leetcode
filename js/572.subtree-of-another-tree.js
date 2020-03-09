/*
 * @lc app=leetcode id=572 lang=javascript
 *
 * [572] Subtree of Another Tree
 */

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}


// @lc code=start
/**
 * @param {TreeNode} s
 * @param {TreeNode} t
 * @return {boolean}
 */
var isSubtree = function(s, t) {
  if (t === null) return true
  if (s === null) return false
  let queue = []
  queue.push(s)
  while (queue.length > 0) {
    let top = queue.shift()
    if (top.left)
      queue.push(top.left)
    if (top.right)
      queue.push(top.right)
    if (top.val === t.val) {
      if (recursion(top, t))
        return true
    }
  }
  return false
};

/**
 * 
 * @param {TreeNode} s 
 * @param {TreeNode} t 
 */
function recursion(s, t) {
  if (s === null && t === null) return true
  if (s === null || t === null) return false

  if (s.val === t.val) return recursion(s.left, t.left) && recursion(s.right, t.right)
  else return false
}
// @lc code=end

let s = new TreeNode(3)
s.left = new TreeNode(4)
s.right = new TreeNode(5)
s.left.left = new TreeNode(1)
s.left.right = new TreeNode(2)

let t = new TreeNode(4)
t.left = new TreeNode(1)
t.right = new TreeNode(2)
t.left.left = new TreeNode(3)

console.log(isSubtree(s, t))
/*
 * @lc app=leetcode id=589 lang=javascript
 *
 * [589] N-ary Tree Preorder Traversal
 */

function Node(val, children) {
  this.val = val;
  this.children = children;
};

// @lc code=start

/**
 * @param {Node} root
 * @return {number[]}
 */
var preorder = function(root) {
  let res = []
  if (!root) return res
  let stack = []
  stack.push(root)
  while (stack.length !== 0) {
    let top = stack.pop()
    res.push(top.val)
    for (let i = top.children.length - 1; i >= 0; i--) {
      stack.push(top.children[i])
    }
  }
  return res
};
// @lc code=end


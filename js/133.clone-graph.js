/*
 * @lc app=leetcode id=133 lang=javascript
 *
 * [133] Clone Graph
 */

function Node(val,neighbors) {
  this.val = val;
  this.neighbors = neighbors;
};

// @lc code=start

/**
 * @param {Node} node
 * @return {Node}
 */
var cloneGraph = function(node) {
  let res = new Node(node.val, [])
  let visited = new Set()
  let stack = [], resStack = []
  resStack.push(res)
  stack.push(node)
  while (stack.length > 0) {
    let top = stack.pop()
    let resTop = stack.pop()
    visited.add(top.val)
    for (let node of top.neighbors) {
      if (!visited.has(node.val)) {
        stack.push(node)
        resTop.neighbors.push(new Node(node.val, []))
        resStack.push(resTop.neighbors[resTop.neighbors.length - 1])
      }
    }
  }
  return res
};
// @lc code=end


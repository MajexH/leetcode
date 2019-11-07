/*
 * @lc app=leetcode id=133 lang=javascript
 *
 * [133] Clone Graph
 */

function Node(val, neighbors) {
  this.neighbors = neighbors;
  this.val = val;
};

// @lc code=start
/**
 * @param {Node} node
 * @return {Node}
 */
var cloneGraph = function(node) {
  let res = new Node(node.val, [])
  let visited = new Map()
  let stack = [], resStack = []
  visited.set(node.val, res)
  resStack.push(res)
  stack.push(node)
  while (stack.length > 0) {
    let top = stack.pop()
    let resTop = resStack.pop()
    // dfs的方式去访问
    for (let node of top.neighbors) {
      if (!visited.has(node.val)) {
        stack.push(node)
        let temp = new Node(node.val, [])
        resStack.push(temp)
        // 加入新的节点
        resTop.neighbors.push(temp)
        // 保存当前节点的引用 必须放在这儿 因为这儿就是第一次访问了
        // 不然会出现问题 也就是stack里面会出现前面一个还在的情况 后面一个相同的节点又进来了
        visited.set(node.val, temp)
      } else {
        // 已经访问过的节点直接加入
        resTop.neighbors.push(visited.get(node.val))
      }
    }
  }
  return res
};
// @lc code=end

let node1 = new Node(1, [])
let node2 = new Node(2, [])
let node3 = new Node(3, [])
let node4 = new Node(4, [])

node1.neighbors.push(node2)
node1.neighbors.push(node4)

node2.neighbors.push(node1)
node2.neighbors.push(node3)

node3.neighbors.push(node2)
node3.neighbors.push(node4)

node4.neighbors.push(node3)
node4.neighbors.push(node1)


console.log(cloneGraph(node1))
/*
 * @lc app=leetcode id=310 lang=javascript
 *
 * [310] Minimum Height Trees
 */

// @lc code=start
let min = 0
/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number[]}
 */
var findMinHeightTrees = function(n, edges) {
  // 构建邻接表
  let array = Array(n).fill(-1)
  for (let edge of edges) {
    if (array[edge[0]] === -1) 
      array[edge[0]] = [edge[1]]
    else 
      array[edge[0]].push(edge[1])
    if (array[edge[1]] === -1) 
      array[edge[1]] = [edge[0]]
    else 
      array[edge[1]].push(edge[0])
  }
  min = Number.MAX_SAFE_INTEGER
  let res = []
  for (let i = 0; i < n; i++) {
    let memo = Array(n).fill(false)
    let temp = getHeight(array, i, memo)
    if (temp < min) {
      min = temp
      res = [i]
    } else if (temp === min) {
      res.push(i)
    }
  }
  return res
};

function getHeight(array, start, memo) {
  memo[start] = true
  let temp = -1
  if (array[start] instanceof Array)
    for (let adjacent of array[start]) {
      if (!memo[adjacent])
        temp = Math.max(temp, getHeight(array, adjacent, memo))
    }
  memo[start] = false
  return temp + 1
}
// @lc code=end

console.log(findMinHeightTrees(1, []))
/*
 * @lc app=leetcode id=463 lang=javascript
 *
 * [463] Island Perimeter
 */

// @lc code=start
/**
 * 实际上就是找到跟水接壤的地方
 * 水除了是0 还有可能是不存在的点
 * @param {number[][]} grid
 * @return {number}
 */
var islandPerimeter = function(grid) {
  let res = 0
  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      if (grid[i][j] === 1) {
        // bfs
        res = bfs(grid, i, j)
        return res
      }
    }
  }
  return res;
};

function bfs(array, indexI, indexJ) {
  let queue = [], res = 0
  let memo = Array(array.length)
  for (let i = 0; i < array.length; i++) {
    memo[i] = Array(array[i].length).fill(true)
  }
  queue.push([indexI, indexJ])
  while (queue.length > 0) {
    let [i, j] = queue.shift()
    memo[i][j] = false
    // 加入上下左右 & 更新res
    if ((i - 1 >= 0) && (array[i - 1][j] === 1)) {
      if (memo[i - 1][j]) {
        queue.push([i - 1, j])
        memo[i - 1][j] = false
      }
    }
    else res++
    if (i + 1 < array.length && array[i + 1][j] === 1) {
      if (memo[i + 1][j]) {
        queue.push([i + 1, j])
        memo[i + 1][j] = false
      }
    }
    else res++
    if (j - 1 >= 0 && array[i][j - 1] === 1) {
      if (memo[i][j - 1]) {
        queue.push([i, j - 1])
        memo[i][j - 1] = false
      }
    }
    else res++
    if (j + 1 < array[i].length && array[i][j + 1] === 1) {
      if (memo[i][j + 1]) {
        queue.push([i, j + 1])
        memo[i][j + 1] = false
      }
    }
    else res++
  }
  return res
}
// @lc code=end

console.log(islandPerimeter([[0,1,0,0],
  [1,1,1,0],
  [0,1,0,0],
  [1,1,0,0]]
 ))
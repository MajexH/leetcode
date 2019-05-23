/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
  let m = grid.length, n = grid[0].length, memo = []
  for (let i = 0; i < m; i++) {
    memo[i] = Array(n).fill(-1)
  }
  // 设置这个的目的是 所有合法路径 最后都会走到这个位置上
  memo[0][0] = grid[0][0]
  return recursion(m - 1, n - 1, memo, grid)
};

function recursion(m, n, memo, grid) {
  // 标识当m < 0 || n < 0的情况下是没法发走这条路的 所以设置成最大 保证在min比较时 不会被选到
  if (m < 0 || n < 0)
    return Number.MAX_SAFE_INTEGER
  if (memo[m][n] !== -1) 
    return memo[m][n]
  // 计算一下 分别走两种方式的最小值 再加上走当前格子的消耗值 就可以得到走到当前位置 所需要的最小步数
  memo[m][n] = Math.min(recursion(m - 1, n, memo, grid), recursion(m, n - 1, memo, grid)) + grid[m][n]
  return memo[m][n]
}

console.log(minPathSum([
  [1,3,1],
  [1,5,1],
  [4,2,1]
]))
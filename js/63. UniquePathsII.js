/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
  let m = obstacleGrid.length, n = obstacleGrid[0].length
  let array = []
  for (let i = 0; i < m; i++) {
    array[i] = Array(n).fill(-1)
  }
  array[0][0] = obstacleGrid[0][0] === 1 ? 0 : 1 
  recursion(m - 1, n - 1, array, obstacleGrid);
  return array[m - 1][n - 1]
};

/**
 * 
 * @param {number} m 
 * @param {number} n 
 * @param {number[][]} memo 
 * @param {number[][]} obstacleGrid 
 */
function recursion(m, n, memo, obstacleGrid) {
  if (m < 0 || n < 0) {
    return 0
  }
  if (memo[m][n] !== -1) {
    return memo[m][n]
  }
  if (obstacleGrid[m][n]) {
    // 只要经过这个有障碍的点 都不可能过去
    memo[m][n] = 0
  } else {
    memo[m][n] = recursion(m - 1, n, memo, obstacleGrid) + recursion(m, n - 1, memo, obstacleGrid)
  }
  return memo[m][n]
}

let a = [
  [1, 0, 0]
]
console.log(uniquePathsWithObstacles(a))
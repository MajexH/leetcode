/*
 * @lc app=leetcode id=63 lang=javascript
 *
 * [63] Unique Paths II
 */

// @lc code=start
/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
  let dp = Array(obstacleGrid.length)
  for (let i = 0; i < obstacleGrid.length; i++) {
    dp[i] = Array(obstacleGrid[i].length)
  }
  dp[0][0] = obstacleGrid[0][0] === 1 ? 0 : 1
  for (let i = 0; i < obstacleGrid.length; i++) {
    for (let j = 0; j < obstacleGrid[i].length; j++) {
      if (i === 0 && j === 0) continue
      if (obstacleGrid[i][j] === 1) dp[i][j] = 0
      else {
        dp[i][j] = (i - 1 >= 0 ? dp[i - 1][j] : 0) + (j - 1 >= 0 ? dp[i][j - 1] : 0)
      }
    }
  }
  return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1]
};
// @lc code=end

console.log(uniquePathsWithObstacles([
  [0,0,0],
  [0,1,0],
  [0,0,0]
]))
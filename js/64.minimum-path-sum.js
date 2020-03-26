/*
 * @lc app=leetcode id=64 lang=javascript
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
  let dp = Array(grid.length)
  for (let i = 0; i < grid.length; i++) {
    dp[i] = Array(grid[i].length).fill(0)
  }
  dp[0][0] = grid[0][0]
  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      if (i === 0 && j === 0) continue
      dp[i][j] = grid[i][j] + Math.min((i - 1 < 0) ? Number.MAX_SAFE_INTEGER : dp[i - 1][j], (j - 1 < 0) ? Number.MAX_SAFE_INTEGER : dp[i][j - 1])
    }
  }
  return dp[grid.length - 1][grid[grid.length - 1].length - 1]
};
// @lc code=end


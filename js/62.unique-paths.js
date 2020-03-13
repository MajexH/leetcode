/*
 * @lc app=leetcode id=62 lang=javascript
 *
 * [62] Unique Paths
 */

// @lc code=start
/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
  let dp = Array(m)
  for (let i = 0; i < m ; i++) {
    dp[i] = Array(n)
  }
  dp[0][0] = 1
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (i === 0 && j === 0) continue;
      dp[i][j] = (i - 1 >= 0 ? dp[i - 1][j] : 0) + (j - 1 >= 0? dp[i][j - 1] : 0)
    }
  }
  return dp[m - 1][n - 1]
};
// @lc code=end

console.log(uniquePaths(7, 3))
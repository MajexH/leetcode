/*
 * @lc app=leetcode id=221 lang=javascript
 *
 * [221] Maximal Square
 */

// @lc code=start
/**
 * dp问题 dp[i][j]代表以[i][j]为右下角的正方形中最大的边长
 * 所以最后的结果是保存在dp[width][length]中
 * 因此转移方程是 因为是取正方形 因此是取 min 因为其实每个就代表了自己能形成的正方形 即从自己为右下角出发 哪些位置是1
 * 在dp[i][j]是1的时候dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function(matrix) {
  let height = matrix.length, width = height > 0 ? matrix[0].length : 0, max = 0
  let dp = Array(width)
  // 初始化dp
  for (let i = 0; i < height; i++) {
    dp[i] = Array(width).fill(0)
  }
  for (let i = 0; i < height; i++) {
    for (let j = 0; j < width; j++) {
      if (matrix[i][j] === '1') {
        dp[i][j] = Math.min(
          i - 1 < 0 ? 0 : dp[i - 1][j], 
          j - 1 < 0 ? 0 : dp[i][j - 1], 
          i - 1 < 0 || j - 1 < 0 ? 0 : dp[i - 1][j - 1]
        ) + 1
        max = Math.max(max, dp[i][j])
      }
    }
  }
  return max * max
};
// @lc code=end

console.log(maximalSquare([]))
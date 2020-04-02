/*
 * @lc app=leetcode id=343 lang=javascript
 *
 * [343] Integer Break
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var integerBreak = function(n) {
  if (n === 1) return null
  // dp[i] 表示 以 i 为最后一个数的前面的 乘积的最大值
  let dp = Array(n + 1).fill(0)
  dp[1] = 1
  for (let i = 2; i <= n; i++) {
    let temp = 0
    for (let j = 1; j <= i; j++) {
      temp = Math.max(Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]), temp)
    }
    dp[i] = temp
  }
  return dp[n]
};
// @lc code=end

console.log(integerBreak(10))
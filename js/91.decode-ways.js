/*
 * @lc app=leetcode id=91 lang=javascript
 *
 * [91] Decode Ways
 */

// @lc code=start
/**
 * dp[i]代表这个i点之前可以形成多少个组合
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
  if (s.startsWith('0')) return 0
  let dp = Array(s.length + 1).fill(0)
  for (let i = 1; i <= s.length; i++) {
    if (i >= 2) {
      if (s.charAt(i - 1) !== '0')
        dp[i] = dp[i - 1]
      let start = i - 2
      // 不一定要找两位 要找到上一个不为0的地方 在判断
      while (s.charAt(start) === '0') start--;
      let temp = Number.parseInt(s.substring(start, i))
      if (temp <= 26 && temp >= 1) {
        dp[i] += start === 0 ? 1 : dp[start]
      }
    } else {
      dp[i] = dp[i - 1] + 1
    }
  }
  return dp[s.length]
};
// @lc code=end


console.log(numDecodings("50926"))
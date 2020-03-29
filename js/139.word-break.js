/*
 * @lc app=leetcode id=139 lang=javascript
 *
 * [139] Word Break
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function(s, wordDict) {
  let set = new Set(wordDict)
  // dp[i] 表示 i 之前的字符串能被找到
  let dp = Array(s.length + 1).fill(false)
  // s 为空字符串时 能找到
  dp[0] = true
  for (let i = 0; i <= s.length; i++) {
    for (let j = 0; j <= i; j++) {
      // 用j作为分隔点 如果 0 - j - 1 即 dp[j] 已经能够被找到
      // 那么只需要知道 j - i 能否在set中找到即可
      if (set.has(s.substring(j, i)) && dp[j]) {
        dp[i] = true
      }
    }
  }
  return dp[s.length]
};
// @lc code=end


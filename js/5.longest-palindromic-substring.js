/*
 * @lc app=leetcode id=5 lang=javascript
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
/**
 * 实际上如果有一个回文数
 * 那么 如果这个回文数 在前后 多加一对相等的数儿
 * 那么 其组成的也是回文数
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
  // memo[i][j] 表示 s 的下标的 i 到 j 之间是一个回文数
  let max = '', memo = Array(s.length + 1)
  for (let i = 0; i <= s.length; i++)
    memo[i] = Array(s.length + 1)
  for (let len = 1; len <= s.length; len++) {
    for (let start = 0; start < s.length; start++) {
      let end = start + len - 1
      if (end >= s.length) break
      // 为什么有len === 1 和 len === 2
      // 因为 要保证 memo[i][j] 的下标中 i <= j
      memo[start][end] = (len === 1 || len === 2 || memo[start + 1][end - 1]) && s.charAt(start) === s.charAt(end)
      if (memo[start][end] && max.length < len) {
        max = s.substring(start, end + 1)
      }
    }
  }
  return max
};
// @lc code=end


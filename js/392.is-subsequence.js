/*
 * @lc app=leetcode id=392 lang=javascript
 * js 的 dp方法 都失败了
 * [392] Is Subsequence
 */

 /**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence1 = function(s, t) {
  let memo = Array(s.length + 1)
  for (let i = 0; i <= s.length; i++) {
    memo[i] = Array(t.length + 1).fill(-1)
  }
  return recurison(s, t, 0, 0, memo)
};

/**
 * 爆栈了 因为可能存在string过长的情况
 * md c++ 不会爆栈
 * @param {String} s 
 * @param {String} t 
 * @param {Number} sIndex 
 * @param {Number} tIndex 
 * @param {Array} memo
 */
function recurison(s, t, sIndex, tIndex, memo) {

  // 边界条件
  if (sIndex === s.length) return true
  if (tIndex === t.length) return false

  if (memo[sIndex][tIndex] !== -1) return memo[sIndex][tIndex]

  // 如果两个位置上的字母是相同的 则意味着要开始遍历 或者这次不遍历
  if (s.charAt(sIndex) === t.charAt(tIndex)) {
    memo[sIndex][tIndex] = recurison(s, t, sIndex + 1, tIndex + 1, memo) || recurison(s, t, sIndex, tIndex + 1, memo)
    return memo[sIndex][tIndex]
  }
  memo[sIndex][tIndex] = recurison(s, t, sIndex, tIndex + 1, memo)
  return memo[sIndex][tIndex]
}
/**
 * 估计只能采用动态规划来做了
 * 动态规划 爆堆了
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence2 = function(s, t) {
  let dp = Array(s.length + 1)
  for (let i = 0; i <= s.length; i++) {
    // s串为空时 表示任何的串都可以匹配
    if (i === 0) dp[i] = Array(t.length + 1).fill(true)
    else dp[i] = Array(t.length + 1).fill(false)
  }
  for (let m = 1; m <= s.length; m++) {
    for (let n = m; n <= t.length; n++) {
      if (s.charAt(m - 1) === t.charAt(n - 1)) {
        dp[m][n] = dp[m - 1][n - 1]
      } else {
        dp[m][n] = dp[m][n - 1]
      }
    }
  }
  return dp[s.length][t.length]
};
// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence = function(s, t) {
  let dp = new Array(s.length + 1)
  for (let i = 1; i <= s.length; i++) {
    dp[i] = Array(t.length + 1).fill(false)
  }
  // 因为s串为空的时候 任何字符串都可以匹配
  dp[0] = Array(t.length + 1).fill(true)
  for (let i = 1; i <= s.length; i++) {
    // 如果 t 串比 s 串长度短 一定不可能
    for (let j = i; j <= t.length; j++) {
      if (s.charAt(i - 1) === t.charAt(j - 1)) {
        dp[i][j] = dp[i - 1][j - 1]
      } else {
        dp[i][j] = dp[i][j - 1]
      }
    }
  }
  return dp[s.length][t.length]
};

// @lc code=end

console.log(isSubsequence('b', 'c'))
/*
 * @lc app=leetcode id=10 lang=javascript
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
/**
 * dp问题 dp[i][j]表示p的i位置 s的j位置能够
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
  let dp = Array(s.length + 1)
  for (let i = 0; i <= s.length; i++) {
    dp[i] = Array(p.length + 1).fill(false)
  }
  dp[0][0] = true
  // 初始化dp
  for (let j = 1; j <= p.length; j++) {
    // 如果s的长度为0 则任何条件下都匹配
    // 为了匹配空串只能存在 a* .*之类的情况 也就是必须要有*
    // 因此只需要找到* 再判断 不存在 a* 存在一个 * 的情况即可
    if (p.charAt(j - 1) === '*')
      if (j > 1 && dp[0][j - 2])
        dp[0][j] = true
  }
  // 循环 为什么有两个循环呢 因为dp[i][j]表示的是
  // s到i的位置之前和p到j的位置之前是否已经匹配
  for (let i = 1; i <= s.length; i++) {
    for (let j = 1; j <= p.length; j++) {
      // 如果两个串匹配
      if (s.charAt(i - 1) === p.charAt(j - 1) || p.charAt(j - 1) === '.') {
        // 当前位数是匹配的 就看前一位 是否是匹配的
        dp[i][j] = dp[i - 1][j - 1]
      } else if (p.charAt(j - 1) === '*'){
        // 如果这个时候p是* 就需要看p前面的一位是什么
        let char = p.charAt(j - 2)
        if (char !== s.charAt(i - 1) && char !== '.') {
          // 如果现在的p的前一位跟现在的s不匹配 那么这时候取 *为0次 因为前面可能是匹配的
          dp[i][j] = (j - 2 >= 0 ? dp[i][j - 2] : false)
        } else {
          /**
           * 这个地方会有三种情况
           * 1、dp[i][j-2] 说明这时候取这个 char* 为0次
           * 2、dp[i][j-1] 为1次
           * 3、dp[i-1][j]为多次 为什么多次呢
           * 因为现在相当于 s的这个位置 已经与p的前一个位置匹配了
           * 但是会出现 aaaaaaaaaaa a* 这种情况 这个时候前面的东西已经匹配了
           * 也就是dp[i-1][j] 其实表示的就是这种情况
           */
          dp[i][j] = dp[i][j - 1] || (j - 2 >= 0 ? dp[i][j - 2] : false) || dp[i - 1][j]
        }
      }
    }
  }
  return dp[s.length][p.length]
};
// @lc code=end

console.log(isMatch("bb", ".bab"))
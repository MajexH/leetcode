/*
 * @lc app=leetcode id=459 lang=javascript
 *
 * [459] Repeated Substring Pattern
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
var repeatedSubstringPattern = function(s) {
  for (let i = 1; i < s.length; i++) {
    // 找到重复的开始
    if (s.charAt(i) === s.charAt(0)) {
      if (check(s, s.substring(0, i), i)) return true
    }
  }
  return false
};

function check(s, str, start) {
  for (let i = start; i < s.length; i += str.length) {
    if (i > s.length) return false
    if (str !== s.substring(i, i + str.length))
      return false
  }
  return true
}
// @lc code=end

console.log(repeatedSubstringPattern('ababba'))
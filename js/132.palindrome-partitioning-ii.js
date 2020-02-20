/*
 * @lc app=leetcode id=132 lang=javascript
 *
 * [132] Palindrome Partitioning II
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var minCut = function(s) {
  let memo = Array(s.length).fill(null)
  return recursion(s, 0, memo).length - 1
};

/**
 * 
 * @param {string} s 
 * @param {number} start 
 * @param {Array} memo 
 */
function recursion(s, start, memo) {
  let temp = []
  if (start >= s.length) {
    return temp
  }
  if (memo[start] !== null) {
    return memo[start]
  }
  for (let i = start + 1; i <= s.length; i++) {
    let tempStr = s.substring(start, i)
    if (checkPalindrome(tempStr)) {
      let res = recursion(s, i, memo)
      // 跟之后的最短的组合
      temp.push([tempStr, ...res])
    }
  }
  let min = Number.MAX_SAFE_INTEGER, minArray = []
  // 从右边开始 筛选出最短的
  for (let array of temp) {
    if (array.length < min) {
      min = array.length
      minArray = array
    }
  }
  // 将最短的缓存 并 返回
  memo[start] = minArray
  return memo[start]
}

function checkPalindrome(s) {
  let start = 0, end = s.length - 1
  while (start < end) {
    if (s.charAt(start++) !== s.charAt(end--)) {
      return false
    }
  }
  return true
}
// @lc code=end

console.log(minCut("aab"))
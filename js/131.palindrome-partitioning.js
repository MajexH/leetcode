/*
 * @lc app=leetcode id=131 lang=javascript
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function(s) {
  let res = []
  recursion(s, 0, res, [])
  return res
};

/**
 * 
 * @param {String} s 
 * @param {number} start
 * @param {Array} res 
 * @param {Array} temp 保存暂时的结果 
 */
function recursion(s, start, res, temp) {
  if (start >= s.length) {
    res.push([...temp])
    return
  }
  for (let i = start + 1; i <= s.length; i++) {
    let tempStr = s.substring(start, i)
    if (checkPalindrome(tempStr)) {
      temp.push(tempStr)
      recursion(s, i, res, temp)
      temp.pop()
    }
  }
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

console.log(partition("aab"))
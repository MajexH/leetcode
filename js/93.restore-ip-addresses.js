/*
 * @lc app=leetcode id=93 lang=javascript
 *
 * [93] Restore IP Addresses
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string[]}
 */
var restoreIpAddresses = function(s) {
  let res = []
  recursion(s, 0, 0, [], res)
  return res
};

/**
 * 
 * @param {String} s 
 * @param {Number} level 
 * @param {Number} start 
 * @param {Array} temp 
 * @param {Array} res 
 */
function recursion(s, level, start, temp, res) {
  if (level === 4) {
    if (start === s.length)
      res.push(temp.join('.'))
    return 
  }
  for (let i = 1; i <= 3; i++) {
    let tempStr = s.substring(start, start + i)
    if (isValid(tempStr)) {
      temp.push(tempStr)
      recursion(s, level + 1, start + i, temp, res)
      temp.pop()
    }
  }
}

function isValid(str) {
  if (str.length > 3 || str.length === 0 || (str.length > 1 && str[0] === '0')) return false
  return Number.parseInt(str) < 256
}
// @lc code=end


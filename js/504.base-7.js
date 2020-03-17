/*
 * @lc app=leetcode id=504 lang=javascript
 *
 * [504] Base 7
 */

// @lc code=start
/**
 * @param {number} num
 * @return {string}
 */
var convertToBase7 = function(num) {
  if (num === 0) return '0'
  let flag = false
  if (num < 0) {
    flag = true
    num = Math.abs(num)
  }
  let res = ''
  while (num !== 0) {
    res = num % 7 + res
    num = Math.floor(num / 7)
  }
  return flag ? '-' + res : res
};
// @lc code=end

console.log(convertToBase7(100))
console.log(convertToBase7(-7))
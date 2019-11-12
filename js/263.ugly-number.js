/*
 * @lc app=leetcode id=263 lang=javascript
 *
 * [263] Ugly Number
 */

// @lc code=start
/**
 * @param {number} num
 * @return {boolean}
 */
var isUgly = function(num) {
  if (num <= 0) return false
  let array = [2, 3, 5], index = 0
  while (num !== 1) {
    while (num % array[index] === 0) {
      num /= array[index]
    }
    index++
    if (index > 2) break
  }
  if (num === 1) return true
  else return false
};
// @lc code=end

console.log(isUgly(14))
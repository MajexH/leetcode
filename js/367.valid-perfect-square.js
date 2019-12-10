/*
 * @lc app=leetcode id=367 lang=javascript
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function(num) {
  let i = 1, j = num
  while (i <= j) {
    let mid = Math.floor((i + j) / 2)
    if (mid * mid > num) {
      j = mid - 1
    } else if (mid * mid < num) {
      i = mid + 1
    } else {
      return true
    }
  }
  return false
};
// @lc code=end

console.log(isPerfectSquare(1))
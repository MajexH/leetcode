/*
 * @lc app=leetcode id=415 lang=javascript
 *
 * [415] Add Strings
 */

// @lc code=start
/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var addStrings = function(num1, num2) {
  let i = num1.length - 1, j = num2.length - 1, res = '', add = 0
  while (i >= 0 && j >= 0) {
    let tempRes = add + Number.parseInt(num1.charAt(i--)) + Number.parseInt(num2.charAt(j--))
    res = tempRes % 10 + res
    add = Math.floor(tempRes / 10)
  }
  while (i >= 0) {
    let tempRes = add + Number.parseInt(num1.charAt(i--))
    res = tempRes % 10 + res
    add = Math.floor(tempRes / 10)
  }
  while (j >= 0) {
    let tempRes = add + Number.parseInt(num2.charAt(j--))
    res = tempRes % 10 + res
    add = Math.floor(tempRes / 10)
  }
  if (add !== 0) res = add + res
  return res
};
// @lc code=end

console.log(addStrings('9', '1'))
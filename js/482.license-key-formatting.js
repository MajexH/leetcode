/*
 * @lc app=leetcode id=482 lang=javascript
 *
 * [482] License Key Formatting
 */

// @lc code=start
/**
 * @param {string} S
 * @param {number} K
 * @return {string}
 */
var licenseKeyFormatting = function(S, K) {
  let str = S.split('-').join("")
  let res = []
  for (let i = str.length - 1; i >= 0; i -= K) {
    if (i - K >= 0) {
      res.push(str.substring(i - K + 1, i + 1).toUpperCase())
    } else {
      res.push(str.substring(0, i + 1).toUpperCase())
    }
  }
  return res.reverse().join('-')
};
// @lc code=end

console.log(licenseKeyFormatting(S = "5F3Z-2e-9-w", K = 4))
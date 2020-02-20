/*
 * @lc app=leetcode id=476 lang=javascript
 *
 * [476] Number Complement
 */

// @lc code=start
/**
 * @param {number} num
 * @return {number}
 */
var findComplement = function(num) {
  let res = 0, record = num
  // 找到最左边的1的位置
  while (num > 0) {
    num >>>= 1
    res = (res << 1) + 1
  }
  return record ^ res
};
// @lc code=end


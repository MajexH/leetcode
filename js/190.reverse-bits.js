/*
 * @lc app=leetcode id=190 lang=javascript
 *
 * [190] Reverse Bits
 */

// @lc code=start
/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
  let res = 0
  // 一个int是4位
  for (let i = 0; i < 32; i++) {
    // 拿到最后一位
    res += n & 1
    // 最后一位不能移动
    if (i < 31)
      res <<= 1
    n >>= 1
  }
  // 有符号数 转换成无符号数
  return res >>> 0
};
// @lc code=end

console.log(reverseBits(4294967293))
/*
 * @lc app=leetcode id=461 lang=javascript
 *
 * [461] Hamming Distance
 */

var hammingDistance1 = function(x, y) {
  let counter = 0
  while (x > 0 || y > 0) {
    if ((x & 1) !== (y & 1)) {
      counter++
    }
    x >>>= 1
    y >>>= 1
  }
  return counter
};
// @lc code=start
/**
 * 这就是异或 想太多
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var hammingDistance = function(x, y) {
  return Number(x ^ y).toString(2).split('').reduce((a, b) => Number.parseInt(a) + Number.parseInt(b))
};
// @lc code=end

console.log(hammingDistance(1,4))

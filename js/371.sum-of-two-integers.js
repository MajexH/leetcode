/*
 * @lc app=leetcode id=371 lang=javascript
 *
 * [371] Sum of Two Integers
 */

// @lc code=start
/**
 * @param {number} a
 * @param {number} b
 * @return {number}
 */
var getSum = function(a, b) {
  if (a === 0) return b
  if (b === 0) return a

  while (b) {
    // 这个地方其实就是计算 现在的进位 与 结果 如果进位的地方 与 结果都是1 
    // 那么相当于这个地方需要进位 然后把这个地方的结果置位0 因此是异或
    let temp = a & b
    // 通过异或操作来计算
    a ^= b
    // 计算进位 利用按位与 操作 计算现在哪些地方需要进位 然后把进位左移一位 与在下一次相加
    b = temp << 1
  }
  return a
};
// @lc code=end


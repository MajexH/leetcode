/*
 * @lc app=leetcode id=405 lang=javascript
 *
 * [405] Convert a Number to Hexadecimal
 */

// @lc code=start
/**
 * 这道题说的补码表示 是用二级制的补码
 * 也就是说答案是要把二级制的32位整数 如-1转换成ffffffff 的形式
 * -1用二级制补码表示为 1111 1111 1111 1111 1111 1111 1111 1111
 * 转换成16进制 则变成 f f f f f f f f
 * @param {number} num
 * @return {string}
 */
var toHex = function(num) {
  if (num === 0) return '0'
  let res = ''
  let array = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
  while (num !== 0) {
    res = array[num & 15] + res
    num = num >>> 4
  }
  return res
};
// @lc code=end

console.log(toHex(-120))
/*
 * @lc app=leetcode id=264 lang=javascript
 *
 * [264] Ugly Number II
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var nthUglyNumber = function(n) {
  // 保存所有的丑数
  let array = Array(n)
  // 规定1是第一个丑数
  array[0] = 1
  // t2 t3 t5分别代表一个分界点
  // 也就是 2 * t2 > max(max是当前最大的丑数)
  let t2 = t3 = t5 = 0
  for (let index = 1; index < n; index++) {
    // 丑数肯定是某个的丑数 乘2 3 5的结果
    array[index] = Math.min(2 * array[t2], 3 * array[t3], 5 * array[t5])
    // 根据当前的最大的丑数 更新值 指向下一个丑数
    while (2 * array[t2] <= array[index]) {
      t2++
    }
    while (3 * array[t3] <= array[index]) {
      t3++
    }
    while (5 * array[t5] <= array[index]) {
      t5++
    }
  }
  return array[n - 1]
};
// @lc code=end

console.log(nthUglyNumber(11))
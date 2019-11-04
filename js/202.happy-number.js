/*
 * @lc app=leetcode id=202 lang=javascript
 *
 * [202] Happy Number
 */

// @lc code=start
/**
 * 如果这个数不能被重新弄到1 则这个数 不停的 这样平方 会形成一个数环
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
  // 记录已经生成的数字
  let set = new Set()
  while (true) {
    if (set.has(n)) return false
    set.add(n)
    let sum = 0
    while (n !== 0) {
      let temp = n % 10
      sum += temp * temp
      n = Math.floor(n / 10)
    }
    n = sum
    if (n === 1) return true
  } 
};
// @lc code=end

console.log(isHappy(15))

/*
 * @lc app=leetcode id=412 lang=javascript
 *
 * [412] Fizz Buzz
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[]}
 */
var fizzBuzz = function(n) {
  let res = Array(n).fill('')
  for (let i = 0; i < n; i++) {
    let number = i + 1, flag = true
    if (number % 3 === 0) {
      res[i] += 'Fizz'
      flag = false
    }
    if (number % 5 === 0) {
      res[i] += 'Buzz'
      flag = false
    }
    if (flag)
      res[i] += number
  }
  return res
};
// @lc code=end

console.log(fizzBuzz(15))
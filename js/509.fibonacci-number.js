/*
 * @lc app=leetcode id=509 lang=javascript
 *
 * [509] Fibonacci Number
 */

// @lc code=start
/**
 * @param {number} N
 * @return {number}
 */
var fib = function(N) {
  let array = Array(N + 1)
  array[0] = 0
  array[1] = 1
  for (let i = 2; i <= N; i++) {
    array[i] = array[i - 1] + array[i - 2]
  }
  return array[N]
};
// @lc code=end

console.log(fib(4))
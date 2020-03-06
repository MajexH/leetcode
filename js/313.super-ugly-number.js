/*
 * @lc app=leetcode id=313 lang=javascript
 *
 * [313] Super Ugly Number
 */

// @lc code=start
/**
 * 跟丑数是一样的 只是跟丑数的要求不用 这个需要把因数抽象出来
 * @param {number} n
 * @param {number[]} primes
 * @return {number}
 */
var nthSuperUglyNumber = function(n, primes) {
  let uglyNumbers = [1]
  let nextUglyNumber = Array(primes.length).fill(0)
  while (uglyNumbers.length < n) {
    let min = Number.MAX_SAFE_INTEGER
    for (let i = 0; i < primes.length; i++) {
      min = Math.min(min, primes[i] * uglyNumbers[nextUglyNumber[i]])
    }
    for (let i = 0; i < primes.length; i++) {
      while (primes[i] * uglyNumbers[nextUglyNumber[i]] <= min) {
        nextUglyNumber[i]++
      }
    }
    uglyNumbers.push(min)
  }
  return uglyNumbers[uglyNumbers.length - 1]
};
// @lc code=end

console.log(nthSuperUglyNumber(12, [2,7,13,19]))
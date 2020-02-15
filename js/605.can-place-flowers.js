/*
 * @lc app=leetcode id=605 lang=javascript
 *
 * [605] Can Place Flowers
 */

// @lc code=start
/**
 * 实际上就找flowerbed中能够放入的花的最大值 是否能够满足 n的要求
 * @param {number[]} flowerbed
 * @param {number} n
 * @return {boolean}
 */
var canPlaceFlowers = function(flowerbed, n) {
  let memo = Array(flowerbed.length).fill(-1)
  return n <= recursion(flowerbed, 0, memo)
};

/**
 * 找到flowerbed中能够放入的最大值
 * @param {number[]} flowerbed 
 * @param {number} start
 * @returns {number}
 */
function recursion(flowerbed, start, memo) {
  if (start >= flowerbed.length) return 0
  if (memo[start] !== -1) return memo[start]
  if ((start === 0 || flowerbed[start - 1] === 0) && (start === flowerbed.length - 1 || flowerbed[start + 1] === 0) && flowerbed[start] === 0) {
    memo[start] = Math.max(recursion(flowerbed, start + 2, memo) + 1, recursion(flowerbed, start + 1, memo))
  } else {
    memo[start] = recursion(flowerbed, start + 1, memo)
  }
  return memo[start]
}
// @lc code=end

console.log(canPlaceFlowers([0,1,0,1,0,1,0,0], 1))
console.log(canPlaceFlowers([1,0,0,0,1], 1))
console.log(canPlaceFlowers([1,0,0,0,1], 2))
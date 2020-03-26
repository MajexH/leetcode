/*
 * @lc app=leetcode id=121 lang=javascript
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
  let max = 0
  let minPrice = Number.MAX_SAFE_INTEGER
  for (let price of prices) {
    minPrice = Math.min(minPrice, price)
    max = Math.max(max, price - minPrice)
  }
  return max
};
// @lc code=end


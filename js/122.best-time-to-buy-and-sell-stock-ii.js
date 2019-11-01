/*
 * @lc app=leetcode id=122 lang=javascript
 *
 * [122] Best Time to Buy and Sell Stock II
 */

/**
 * 但是用recursion的方式去解也不是可行的 因为会导致整个超时
 * 因为其实这就是去遍历的所有的可能
 * 每一轮都去找当前的最优解是不可行的 因为最后组合出来的数可能相对较小
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit1 = function(prices) {
  return recursion(prices, 0, 0, true)
};

function recursion(prices, index, sum, flag) {
  // flag 为true 表示买进 为false 表示卖出
  if (index >= prices.length) return sum
  let max
  if (flag) {
    // 我现在要买进 现在也有两个选择 买或者不买
    max = Math.max(recursion(prices, index + 1, sum, true),
              recursion(prices, index + 1, sum - prices[index], false))
  } else {
    // 我现在要卖出 我有两种情况 我可以选择卖 也可以选择不卖
    max = Math.max(recursion(prices, index + 1, sum + prices[index], true), 
              recursion(prices, index + 1, sum, false))
  }
  return max
}

// @lc code=start
/**
 * 然而其实 这个解就是所有的波峰和谷底的 值
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
  let valley = prices[0], peak = prices[0], i = 0, max = 0
  while (i < prices.length - 1) {
    while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
      i++
    }
    valley = prices[i]
    while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
      i++
    }
    peak = prices[i]
    console.log(peak, valley)
    max += peak - valley
  }
  return max
};
// @lc code=end

console.log(maxProfit([3,3,5,0,0,3,1,4]))
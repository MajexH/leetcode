/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
  let max = 0, miniprice = Number.MAX_SAFE_INTEGER
  for (let item of prices) {
    if (item < miniprice)
      miniprice = item
    if (item - miniprice >= max)
      max = item - miniprice
  }
  return max
};

console.log(maxProfit([1,2,11,4,7]))
/**
 * 给定一组array 找到其中的最大利润
 * 即找到一个买入点和一个卖出点 找到其最大利润
 * 为了找到最大利润 就需要找到最小的买入点和最大的卖出点
 * @param {number[]} array 
 */
function maxProfitOfStocks(array) {
  let maxProfit = Number.MIN_SAFE_INTEGER
  let min = array[0]
  for (let i = 1; i < array.length; i++) {
    // i 下标前的最小值
    min = Math.min(min, array[i])
    // 知道前面的最小值 只需要比较每个利润的最大值即可
    maxProfit = Math.max(maxProfit, array[i] - min)
  }
  return maxProfit
}

console.log(maxProfitOfStocks([9,11,8,5,7,12,16,14]))
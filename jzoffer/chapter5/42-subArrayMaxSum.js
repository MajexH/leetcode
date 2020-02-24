/**
 * 找到一个数组中的连续子数组的最大的和
 * @param {Array} array 
 */
function maxSubArraySum(array) {
  // dp[i] 表示i之前的最大的和为多少
  let dp = Array(array.length + 1)
  // 初始化
  let max = Number.MIN_SAFE_INTEGER
  dp[0] = Number.MIN_SAFE_INTEGER
  for (let i = 1; i <= array.length; i++) {
    dp[i] = Math.max(array[i - 1], array[i - 1] + dp[i - 1])
    max = Math.max(dp[i], max)
  }
  return max
}

console.log(maxSubArraySum([1,-2,3,10,-4,7,2, -5]))
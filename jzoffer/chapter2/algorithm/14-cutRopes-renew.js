/**
 * 给定一个长度为n的绳子
 * 求切成几段都 其 a[0] * a[1] *……* a[m] 的值最大
 * @param {number} n 
 */
function cutRopes(n) {
  // dp[i] 表示长度为i的时候的乘积最大值
  let dp = Array(n + 1).fill(0)
  dp[0] = 0
  dp[1] = 1
  for (let i = 1 ; i <= n; i++) {
    for (let j = 1; j <= Math.floor(i / 2); j++) {
      dp[i] = Math.max(Math.max(dp[j], j) * Math.max(dp[i - j], i - j), dp[i])
    }
  }
  console.log(dp)
  return dp[n]
}

console.log(cutRopes(50) === 86093442)
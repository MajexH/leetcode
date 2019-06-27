/**
 * 这个思路很简单 就是dp[i]里面保存了n=i时 能够取得的最大值
 * 所以 算下一个i+1的最大值的时候 只需要遍历1->(i+1)/2 算出最大值即可
 * @param {number} n
 * @return {number}
 */
var integerBreak = function(n) {
  // dp里面保存的就是每个n下对应的最大值
  let dp = Array(59)
  dp[1] = 1
  dp[2] = 1
  for (let i = 3; i <= n; i++) {
    let max = 0
    for (let j = 1; j <= i / 2; j++) {
      max = Math.max(max, Math.max(i - j, dp[i - j]) * Math.max(j, dp[j]))
    }
    dp[i] = max
  }
  return dp[n]
};

console.log(integerBreak(58))
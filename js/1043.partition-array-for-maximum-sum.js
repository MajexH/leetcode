/*
 * @lc app=leetcode id=1043 lang=javascript
 *
 * [1043] Partition Array for Maximum Sum
 */

// @lc code=start
/**
 * @param {number[]} A
 * @param {number} K
 * @return {number}
 */
var maxSumAfterPartitioning = function(A, K) {
  // dp[i] 表示 以 A[i] 结尾的前面的最大值
  let dp = Array(A.length).fill(0)
  for (let i = 0; i < A.length; i++) {
    // 记录最大值
    let max = Number.MIN_SAFE_INTEGER
    for (let j = i; j >= Math.max(0, i - K + 1); j--) {
      max = Math.max(max, A[j])
      // 这个地方是这么比较的
      // 就是用 从 j = i 开始 向前 数 K 个 数
      // 把每个的最大值 拿来跟 后面的 最大值的和比较
      // 这样就是这个 i 结尾的 数 能够变出来的最大值了
      dp[i] = Math.max(dp[i], (j - 1 < 0 ? 0 : dp[j - 1]) + max * (i - j + 1))
    }
  }
  return dp[A.length - 1]
};
// @lc code=end

console.log(maxSumAfterPartitioning([1,15,7,9,2,5,10], 3))
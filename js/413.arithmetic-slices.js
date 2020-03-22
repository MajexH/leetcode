/*
 * @lc app=leetcode id=413 lang=javascript
 *
 * [413] Arithmetic Slices
 */

// @lc code=start
/**
 * @param {number[]} A
 * @return {number}
 */
var numberOfArithmeticSlices = function(A) {
  if (A.length < 3) return 0
  // dp 存储的是长度减2
  // 因为 实际上一个长度为n的连续数列 其所有的组合为 n-2 的累加
  let res = 0, dp = Array(A.length).fill(0)
  for (let i = 2; i < A.length; i++) {
    if (A[i] - A[i - 1] === A[i - 1] - A[i - 2]) {
      dp[i] = dp[i - 1] + 1
      res += dp[i]
    }
  }
  return res
};
// @lc code=end

console.log(numberOfArithmeticSlices([1, 2, 3, 4]))
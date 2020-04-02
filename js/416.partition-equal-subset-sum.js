/*
 * @lc app=leetcode id=416 lang=javascript
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canPartition = function(nums) {
  let sum = nums.reduce((pre, cur) => pre + cur, 0)
  // 分成相等的两份 如果和不为偶数 是不可能的
  if (sum % 2 !== 0) return false
  // dp[i][j] 表示 前i个数的和能否为j
  let dp = Array(nums.length + 1)
  for (let i = 0; i <= nums.length; i++) {
    dp[i] = Array((sum / 2) + 1).fill(false)
    dp[i][0] = true
  }
  for (let i = 1; i <= nums.length; i++) {
    for (let j = 0; j <= sum / 2; j++) {
      if (j - nums[i - 1] >= 0) {
        // || 前同下 后面是一个是去除掉当前访问的最后一个数 能否和为j
        // 因此是 dp[i - 1][j - nums[i - 1]]
        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]
      } else {
        // 如果 和 j 小于 当前的 nums[i] 则查看 如果少一个数 能够达成和为j
        dp[i][j] = dp[i - 1][j]
      }
    }
  }
  return dp[nums.length][sum / 2]
};
// @lc code=end

console.log(canPartition([1, 5, 11, 5]))
/*
 * @lc app=leetcode id=53 lang=javascript
 *
 * [53] Maximum Subarray
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
  let max = nums[0]
  let dp = Array(nums.length)
  dp[0] = nums[0]
  for (let i = 1; i < nums.length; i++) {
    // 如果前面的和是负数的话就重新开始
    // 因为如果dp[i-1]是负数的话 dp[i]会变小
    dp[i] = nums[i] + (dp[i - 1] < 0 ? 0 : dp[i - 1])
    // 因为最大值可能在中间 因此记录一下
    max = Math.max(max, dp[i])
  }
  return max
};
// @lc code=end


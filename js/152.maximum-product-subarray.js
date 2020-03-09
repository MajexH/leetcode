/*
 * @lc app=leetcode id=152 lang=javascript
 *
 * [152] Maximum Product Subarray
 */

var maxProduct1 = function(nums) {
  let min = nums[0], max = nums[0], res = nums[0]
  for (let i = 1; i < nums.length; i++) {
    if (nums[i] < 0) {
      let temp = max
      max = min
      min = temp
    }
    max = Math.max(nums[i], max * nums[i])
    min = Math.min(nums[i], min * nums[i])
    res = Math.max(max, res)
  }
  return res
};

// @lc code=start
/**
 * 给定一个nums
 * 找到其中的一个连续子数列 其乘积最大
 * // 相较于53题 这道题 其实就多了一个条件
 * // 乘法 两个负数相乘会使得 本来之前的较小的值 变得大起来
 * 因为 负负得正
 * 因此 除了计算当前的最大值之外 还需要保存最小值 因为一旦有成对的负数
 * 这个最小值 就会变成最大值
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
  let res = nums[0]
  // dp[i] 表示 当前以nums[i] 为结尾的最大乘积和最小乘积的tuple
  let dp = Array(nums.length)
  dp[0] = [nums[0], nums[0]]
  for (let i = 1; i < nums.length; i++) {
    let preMax = dp[i - 1][0], preMin = dp[i - 1][1]
    if (nums[i] < 0) {
      let temp = preMax
      preMax = preMin
      preMin = temp
    }
    // 因为存在偶数个负数的情况 所以可能存在 max min 反转
    let max = Math.max(nums[i], nums[i] * preMax)
    let min = Math.min(nums[i], nums[i] * preMin)

    dp[i] = [max, min]
    res = Math.max(res, max)
  }
  return res
};
// @lc code=end

console.log(maxProduct([-1,-2,-9,-6]))